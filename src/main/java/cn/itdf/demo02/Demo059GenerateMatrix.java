package cn.itdf.demo02;

/**
 * 题目:螺旋矩阵 II
 *
 * 思路:
 *
 *
 */
public class Demo059GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        // 用数组记录各个阶段的运动模式
        int[][] move = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // f为0/1/2/3时分别表示向右/下/左/上运动
        int f = 0, k = 0, i = 0, j = 0;
        for (int m = 1; m <= n * n; m++) {
            ret[i][j] = m;
            // 在各个拐点改变运动方向
            if (f == 0 && j == n - k - 1) f = 1;
            if (f == 1 && i == n - k - 1) f = 2;
            if (f == 2 && j == k) f = 3;
            if (f == 3 && i == k + 1) {
                f = 0;
                // k表示起始位,因此走完一圈就要往里缩进
                k++;
                i = k;
                j = k - 1;
            }
            i += move[f][0];
            j += move[f][1];
        }
        return ret;
    }
}
