package cn.itdf.B_normal;

/**
 * 题目:最大正方形
 *
 * 思路:
 *      一 暴力法
 *
 *      二 动态规划
 *          当一个点是1,决定能否成正方形的是它左边,上边,左上三个点的情况
 *          (当时我想到上面这一点了,但是没想到一种好的办法去记录和传递已探测到的数值情况)
 *          官方解法的妙处在于 每个点的值等于其旁边三个点的最小值+1,因而边长有0的情况下只能=1,而在叠加正方形的时候=2, 3...
 *          结合动态规划的做法两层遍历就能得出最终解了
 *
 *
 */
public class Demo221MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 只有 == 1的情况才需要处理,省略掉不必要的操作
                if (matrix[i][j] == '1') {
                    // 边缘位置的元素只能=原值
                    if (i == 0 || j == 0) {
                        ret[i][j] = 1;
                    }else {
                        // 其余位置的元素=min(旁边三点)+1
                        ret[i][j] = Math.min(Math.min(ret[i-1][j], ret[i][j-1]), ret[i-1][j-1]) + 1;
                    }
                }
                count = Math.max(count, ret[i][j]);
            }
        }
        return count * count;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        maximalSquare(arr);
    }
}
