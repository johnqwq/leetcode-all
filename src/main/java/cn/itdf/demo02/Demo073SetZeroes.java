package cn.itdf.demo02;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目:矩阵置零
 *
 * 思路:
 *      一 额外存储空间方法
 *          用二维数组或者Set记录需要置零的行和列
 *
 *      二 O(1)空间的暴力
 *          遍历每个格子,如果为0的话则将对应的行头和列头设置为0,最后根据这些0来将整行置零
 *          时间复杂度：O(M×N)
 *
 *
 */
public class Demo073SetZeroes {
    /**
     * 额外存储空间的方法
     * @param matrix
     */
//    public void setZeroes(int[][] matrix) {
//        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return;
//        int m = matrix.length;
//        int n = matrix[0].length;
//        Set<Integer> rowSet = new HashSet<>();
//        Set<Integer> colSet = new HashSet<>();
//        // 遍历数组,用Set记录需要置零的行和列
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0) {
//                    rowSet.add(i);
//                    colSet.add(j);
//                }
//            }
//        }
//        // 置零
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (rowSet.contains(i) || colSet.contains(j)) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }

    /**
     * O(1)空间的暴力
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return;
        int m = matrix.length;
        int n = matrix[0].length;

        // 每一行的元素都可以用行头和行列表示该行是否置零,除了第一行和第一列,对应的格子重复了,因此需要额外一个变量来记录
        // 记录第一列是否置零
        boolean isFirstColZero = false;
        for (int i = 0; i < m; i++) {
            // 如果第一列上的元素有0,整列置零
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
            }
            // 第2到最后一列的情况
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 如果第一行的标记为0,则第一行整行置零
        if (matrix[0][0] == 0) {
            for (int i = 1; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        // 第一列的标记为0,整列置零
        if (isFirstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
