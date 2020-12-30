package cn.itdf.B_normal;

/**
 * 题目:不同路径 II
 *
 * 思路:
 *      动态规划
 *          和上一题类似,不同的地方在于所有有障碍的格子都要记为0,右/下边界的值等于下边/右边的值
 *
 *
 */
public class Demo063UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1] == 1) return 0;
        int[][] count = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 终点记为1
                if (i == m - 1 && j == n -1) {
                    count[i][j] = 1;
                }else if (obstacleGrid[i][j] == 1) {
                    // 有障碍的地方记为0
                    count[i][j] = 0;
                }else {
                    if (i == m - 1) {
                        // 下边界=右边的值
                        count[i][j] = count[i][j+1];
                    }else if (j == n - 1) {
                        // 右边界=下边的值
                        count[i][j] = count[i+1][j];
                    }else {
                        // 其余位置=右边+下边
                        count[i][j] = count[i+1][j] + count[i][j+1];
                    }
                }
            }
        }
        return count[0][0];
    }
}
