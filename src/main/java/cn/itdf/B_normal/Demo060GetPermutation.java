package cn.itdf.B_normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目:第k个排列
 *
 *      思路:
 *          一 阶乘数系统
 *              排列中的每种情况都可以映射到 (n-1)! >> 1! 上
 *              比如 n=3时各个排列可以拆解成:
 *                  0 = 0 * 2 + 0 * 1 + 0 * 0 = get(0) + get(0) + get(0) = 123
 *                  1 = 0 * 2 + 1 * 1 + 0 * 0 = get(0) + get(1) + get(0) = 132
 *                  2 = 1 * 2 + 0 * 1 + 0 * 0 = get(1) + get(0) + get(0) = 213
 *                  3 = 1 * 2 + 1 * 1 + 0 * 0 = get(1) + get(1) + get(0) = 231
 *                  4 = 2 * 2 + 0 * 1 + 0 * 0 = get(2) + get(0) + get(0) = 312
 *                  5 = 2 * 2 + 1 * 1 + 0 * 0 = get(2) + get(1) + get(0) = 321
 *              此时每一个乘数表达式左边的数就对应着索引,右边的数就是 (n-1)! >> 1!
 *              因此当 n=4就会有:
 *                  0  = 0 * 6 + 0 * 2 + 0 * 1 + 0 * 0 = get(0) + get(0) + get(0) + get(0) = 1234
 *                  ...
 *                  ...
 *                  23 = 3 * 6 + 2 * 2 + 1 * 1 + 0 * 0 = get(3) + get(2) + get(1) + get(0) = 4321
 *              而左边的数可以怎么求呢?
 *              就是用 (k-1) / [(n-1)! >> 1!],  (k只需要减一次1)
 *              例如当k=3, 就有 3-1 / 2 * 1 = 1,对应着上面的 1 * 2;
 *              再求下一位的时候,需要先去掉 1 * 2 的影响,然后找到到底是 0 * 1 还是 1 * 1,从而确认下一位的索引
 *              (2 - 1 * 2) / 1! = 0,因此
 *
 *
 */
public class Demo060GetPermutation {
    /**
     * 这是自己写的方法,和阶乘数系统的思路可能有点区别
     * 想了一下发现自己的这个方法其实核心就是阶乘数系统的映射
     * ,只不过我是通过边界的变化来找到 k 和 (n-1)! >> 1! 的;而官方思路就能直接提炼出变化规律
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        // 左右边界
        int l = 1, r = 1;
        StringBuilder builder = new StringBuilder();
        // 填入每个数
        for (int i = 1; i <= n; i++) {
            r *= i;
            list.add(i);
        }
        for (int i = n; i > 0; i--) {
            if (i == 1) {
                builder.append(list.remove(0));
                break;
            }
            // 计算各个位数上的基数(比如当n=3,第一位可能出现1/2/3三种情况,基数就是6/3=2),
            // 通过计算k拥有的基数可以确定当前位数是哪个值(全排列且为顺序排列的时候适用),
            // 比如当 k = 3, (k-1) / 2 = 1,得到的1就是索引,指向了2这个值,因此该位就是2
            // (然后缩小边界接着进行k和基数的比较)
            int base = (r - l + 1) / i; // 这里的基数实际上就是 (n-1)!
            int m = (k - l) / base; // 这里的(k - l)是笨拙地通过边界的变化来求的
            builder.append(list.remove(m));
            l += m * base;
            r = l + base - 1;
        }
        return builder.toString();
    }

    /**
     * 阶乘数系统的思路
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation1(int n, int k) {
        StringBuilder sb = new StringBuilder();
        // 候选数字
        List<Integer> candidates = new ArrayList<>();
        // 分母的阶乘数
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        int fact = 1;
        for(int i = 1; i <= n; ++i) {
            candidates.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        k -= 1;
        for(int i = n-1; i >= 0; --i) {
            // 根据阶乘数系统找到对应的index
            int index = k / factorials[i];
            sb.append(candidates.remove(index));
            // 去除已找到的数的影响
            k -= index*factorials[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 4));
    }
}
