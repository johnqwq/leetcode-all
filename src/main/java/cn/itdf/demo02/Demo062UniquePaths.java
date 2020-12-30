package cn.itdf.demo02;

/**
 * 题目:不同路径
 *
 * 思路:
 *      动态规划
 *          和青蛙跳台阶的思路类似
 *          每一格的走法等于右边走法+下边走法
 *          因此从右下钟点倒着回推到左上起点就能得到结果了
 *
 *
 */
public class Demo062UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] count = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    // 边界统一只有1种走法
                    count[i][j] = 1;
                }else {
                    // 其余位置=右+下
                    count[i][j] = count[i + 1][j] + count[i][j + 1];
                }
            }
        }
        return count[0][0];
    }
}
