package cn.itdf.demo02;

/**
 * 题目：Pow(x, n)
 *
 * 思路：
 *      快速幂算法（递归）
 *      A = x ^ (n / 2)，那么就有 x ^ n = A * A （偶数n） 或者 n = A * A * x（奇数n）
 *
 *      如果说快速幂算法是  (x ^ n) ^ 2 = x ^ {2 * n}
 *      则下面最后一种方法是 (x ^ 2) ^ n = x ^ {2 * n}
 *
 *
 */
public class Demo050MyPow {
    /**
     * 这是我用之前做累加和的思路写的，比暴力算法要快，但是还是没把 幂运算的特点完全发挥出来
     * 基本过程还是 2 的级数的累乘，所以时间复杂度接近 O(logN)
     * @param x
     * @param n
     * @return
     */
    /*
    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        // 记录正负数后统一转成负数，避免溢出
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
        }else {
            n = -n;
        }
        if (isNegative) {
            return 1 / pow(1, x, n);
        }else {
            return pow(1, x, n);
        }
    }

    public static double pow(double y, double x, int n) {
        if (n >= 0) {
            return y;
        }
        // 保证每次递归至少能运算一次
        double ret = x;
        n += 1;
        // 用以计算 2 * c对应的基数
        double count = x;
        int c = -1;
        while (n <= 2 * c) {
            // 当n <= 2 * c时，ret可以一次乘 count * count 而不用分解地去乘一个个 x
            ret *= count * count;
            count *= count;
            n -= 2 * c;
            c *= 2;
        }
        // 确保n都被运算完成
        y *= pow(ret, x, n);
        return y;
    }
    */

    /**
     * 这是网上大牛的代码，非常的优雅
     * 思路应该就是快速幂算法，时间复杂度O(logN)
     * @param x
     * @param n
     * @return
     */
//    public static double myPow(double x, int n) {
//        if (n == 0) {
//            return 1;
//        }
//        if (n == 1) {
//            return x;
//        }
//        if (n == -1) {
//            return 1 / x;
//        }
//        double half = myPow(x, n / 2);
//        double mod = myPow(x, n % 2);
//        return half * half * mod;
//    }

    /**
     * 这同样是网上大牛的代码，思路和代码都是一流水准
     * 原理：把底数变大，指数变小，res存储损失的值
     * 时间复杂度 O(logN)
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            // 此处if的两个作用：存储损失值；最后一次i/2必然为1即奇数，所以最终得到的x和损失量相乘得到最终结果
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 7));
    }
}
