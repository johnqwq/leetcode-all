package cn.itdf.B_normal;

/**
 * 题目：旋转图像
 *
 * 思路：
 *      一 转置 + 翻转
 *          矩阵的转置 [i][j] = [j][i]
 *          翻转 [i][j] = [i][L-j-1]
 *      二 在单次循环中旋转四个矩形
 *
 *      注意这两种方法的时间复杂度都是O(N^2)
 *
 *
 */
public class Demo048Rotate {
//    public void rotate(int[][] matrix) {
//        // 用双向队列来暂时存储元素
//        Deque<Integer> deque = new ArrayDeque<>();
//        int L = matrix.length;
//        // 单次循环中旋转四个矩形
//        for (int i = 0; i + 1 <= L / 2; i++) {
//            for (int j = i; j < L - i - 1; j++) {
//                // 这里的思路是对的，但是存储的方式还是稍显复杂了，原因在于我老是想着从前往后放所以没法只用一个temp
//                // 实际上只要用一个temp存着第一个元素，然后从最后一个元素开始移动，最后再把第一个元素放好就可以了
//                deque.add(matrix[i][j]);
//                deque.add(matrix[j][L-1-i]);
//                matrix[j][L-1-i] = deque.pop();
//                deque.add(matrix[L-1-i][L-1-j]);
//                matrix[L-1-i][L-1-j] = deque.pop();
//                deque.add(matrix[L-1-j][i]);
//                matrix[L-1-j][i] = deque.pop();
//                matrix[i][j] = deque.pop();
//            }
//        }
//    }

    public void rotate(int[][] matrix) {
        int L = matrix.length;
        // 单次循环中旋转四个矩形
        for (int i = 0; i + 1 <= L / 2; i++) { // 注意这里的边界设定
            for (int j = i; j < L - i - 1; j++) { // 注意每行限定范围内的最后一个元素是不用移动的，因为第一个元素会覆盖掉
                int temp = matrix[i][j];
                matrix[i][j] = matrix[L-1-j][i];
                matrix[L-1-j][i] = matrix[L-1-i][L-1-j];
                matrix[L-1-i][L-1-j] = matrix[j][L-1-i];
                matrix[j][L-1-i] = temp;
            }
        }
    }
}
