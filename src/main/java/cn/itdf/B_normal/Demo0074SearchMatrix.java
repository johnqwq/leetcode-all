package cn.itdf.B_normal;

/**
 * 题目:搜索二维矩阵
 *
 * 思路:
 *      一 暴力
 *      二 二分查找
 *          把二维数组平放,就相当于一个有序的一位数组,此时可直接使用二分法
 *          (但是这里计算索引可能会绕一点)
 *          时间复杂度O(log(M*N))
 *      三 缩小领域
 *          剑指offer上的方法,从左下角/右上角开始移动查找
 *          时间复杂度O(M+N)
 *
 *
 */
public class Demo0074SearchMatrix {
    /**
     * 缩小领域
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            }else if (matrix[i][j] < target) {
                j++;
            }else {
                return true;
            }
        }
        return false;
    }
}
