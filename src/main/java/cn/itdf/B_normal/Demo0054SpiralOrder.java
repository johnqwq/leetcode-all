package cn.itdf.B_normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：螺旋矩阵
 *
 * 思考：
 *      按层模拟
 *
 *      时间复杂度： O(N)，其中 N 是输入矩阵所有元素的个数。因为我们将矩阵中的每个元素都添加进答案里
 *
 *
 */
public class Demo0054SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return ret;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int a = 0, b = 0; a <= (m-1) / 2 && b <= (n-1) / 2; a++, b++) {
            for (int j = b; j < n - b; j++) {
                ret.add(matrix[a][j]);
            }
            for (int i = a + 1; i < m - a; i++) {
                ret.add(matrix[i][n - b - 1]);
            }
            for (int j = n - b - 2; m - a - 1 > a && j >= b; j--) {
                ret.add(matrix[m - a - 1][j]);
            }
            for (int i = m - a - 2; n - b - 1 > b && i > a; i--) {
                ret.add(matrix[i][b]);
            }
        }
        return ret;
    }
}
