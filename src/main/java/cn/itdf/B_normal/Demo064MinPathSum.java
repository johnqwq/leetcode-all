package cn.itdf.B_normal;

/**
 * 题目:最小路径和
 *
 * 思路:
 *      一 暴力
 *      二 二维动态规划
 *      三 一维动态规划
 *          和二维的类似,只不过可以只用一个一维数组来存储结果(因为在任何一个状态下只有向右和向下两种可能)
 *      四 动态规划
 *          直接存放在原数组中
 *
 *
 */
public class Demo064MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    continue;
                }else if (i == m - 1) {
                    grid[i][j] += grid[i][j+1];
                }else if (j == n - 1) {
                    grid[i][j] += grid[i+1][j];
                }else {
                    grid[i][j] += Math.min(grid[i+1][j], grid[i][j+1]);
                }
            }
        }
        return grid[0][0];
    }
}
