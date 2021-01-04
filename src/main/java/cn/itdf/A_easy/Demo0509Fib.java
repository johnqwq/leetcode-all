package cn.itdf.A_easy;

/**
 * 题目: 斐波拉契数列
 *      如果是反向递归可能会导致调用过深或者内存溢出
 *      综合来看从123慢慢计算到N反而是性能最好的办法
 *
 */
public class Demo0509Fib {
    public int fib(int n) {
        if (n < 3) {
            return (n + 1) / 2;
        }
        int result = 0, pre2 = 1, pre = 1;
        for (int m = 3; m <= n; m++) {
            result = pre2 + pre;
            pre2 = pre;
            pre = result;
        }
        return result;
    }
}
