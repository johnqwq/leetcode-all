package cn.itdf.B_normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：括号生成
 *
 * 思路：
 *      回溯法：
 *          按照深度优先搜索的策略，从根结点出发深度探索解空间树。
 *          当探索到某一结点时，要先判断该结点是否包含问题的解，
 *          如果包含，就从该结点出发继续探索下去，如果该结点不包含问题的解，则逐层向其祖先结点回溯
 *
 *      本题解题的关键在于控制好两个限制条件：
 *          左右括号的数量不能超过n
 *          添加右括号前需保证前面有未配对的左括号
 *
 *      而这两个条件在程序中可以用两个变量来控制：
 *          c：c不为0则可以添加右括号，添加后c-1
 *          n：n不为0则可以添加左括号，添加后n-1，c+1
 *
 *      这两个条件结合回溯法能得到所以解
 *
 * 性能考虑：
 *      以前做过一个 电话号码的字母组合，当时用字符串拼接的方式比较方便性能也比较好
 *      但在本题中不适用，本题试用字符数组的方式性能有进一步的提升
 *
 *
 */
public class Demo022GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        int count = 0;
        List<String> ret = new ArrayList<>();
        char[] arr = new char[n * 2];
//        get(ret, "", n, count);
        get(ret, arr, 0, n, count);
        return ret;
    }

    /**
     * 使用字符数组的方式【推荐】
     * @param ret
     * @param arr
     * @param i
     * @param n
     * @param c
     */
    public static void get(List<String> ret, char[] arr, int i, int n, int c) {
        if (n > 0) {
            if (c > 0) {
                arr[i] = ')';
                get(ret, arr, i+1, n, c-1); // c：c不为0则可以添加右括号，添加后c-1
            }
            arr[i] = '(';
            get(ret, arr, i+1, n-1, c+1); // n不为0则可以添加左括号，添加后n-1，c+1
        }else if (c > 0) { // 确保n c 都为0才可以添加到结果集
            arr[i] = ')';
            get(ret, arr, i+1, n, c-1);
        }else {
            ret.add(new String(arr));
        }
    }

    /**
     * 使用字符串拼接的方式
     * @param ret
     * @param s
     * @param n
     * @param c
     */
    public static void get(List<String> ret, String s, int n, int c) {
        if (n > 0) {
            if (c > 0) {
                get(ret, s+"(", n-1, c+1);
                get(ret, s+")", n, c-1);
            }else {
                get(ret, s+"(", n-1, c+1);
            }
        }else if (c > 0) {
            get(ret, s+")", n, c-1);
        }else {
            ret.add(s);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
