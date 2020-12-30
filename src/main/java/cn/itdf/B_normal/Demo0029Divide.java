package cn.itdf.B_normal;

/**
 * 题目：两数相除
 *
 * 思路：
 *      一、递归逼近
 *          题目要求不能用乘法、除法和mod运算，因此一个常规的思路是累加divisor并计算次数
 *          问题在于逐个+divisor 性能太差，当碰到比较大的 dividend 就会超时
 *          解决：用翻倍的方式替换逐个累加；翻倍超出后dividend减去已计算的，再次从divisor翻倍累加，直到加一个divisor都不行
 *
 *      二、位移算法
 *          不会所以暂时不列出来
 *
 *
 */
public class Demo0029Divide {
    public static int divide(int dividend, int divisor) {
        // 这道题目对边界处理同样有要求
        if (dividend == 0) {
            return 0; // 被除数为0时返回0
        }else if (divisor == 1) {
            return dividend; // 除数为1时直接返回被除数
        }else if (divisor == -1) {
            // 如果被除数为Integer的最小值，取相反数时会溢出，此时按题目要求返回Integer.MAX_VALUE
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }else {
                return -dividend; // 除数为-1时直接返回被除数的相反数
            }
        }

        int d = dividend;
        int r = divisor;

        // 标记正负符号
        boolean isPositive = false;
        if (d<0&&r<0 || d>0&&r>0) {
            isPositive = true;
        }

        // 如果统一转为正数计算，则遇到Integer.MIN_VALUE会溢出，所以这里巧妙地全部转为负数计算（不影响结果）
        d = d > 0 ? -d : d;
        r = r > 0 ? -r : r;

        // 计算商
        int ret = div(d, r);

        return isPositive ? ret : -ret;
    }

    /**
     * 递归逼近结果
     * 注意这个方法里全都是基于负值的计算
     * @param d
     * @param r
     * @return
     */
    public static int div(int d, int r) {
        // 被除数大于除数，则逼近结束
        if (d > r) {
            return 0;
        }
        // 如果通过了上面的判断，则至少可以逼近一个divisor单位
        int ret = 1; // 由于每次递归这里都默认逼近一个divisor单位（最小单位），所以可以保证得到的是正确解
        int sum = r;
        // 尝试累加逼近
        while (sum+sum >= d && sum+sum < 0) { // 这里的sum+sum要注意越加越大然后溢出的情况(溢出了同样说明无法累加逼近了)
            sum += sum;
            ret += ret;
        }
        // 本次累加逼近结束后dividend 减去逼近长度sum，继续下一次的累加逼近
        return ret + div(d-sum, r);
    }

    public static void main(String[] args) {
        divide(1530093783, 1493139203);
    }
}
