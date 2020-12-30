package cn.itdf.B_normal;

/**
 * 题目:单词搜索
 *
 * 思路:
 *      DFS + 回溯
 *      这是我自己写的版本,速度超过80.79%的用户,应该还算可以
 *      但是我自己写的时候没有意识到这就是DfS + 回溯
 *
 *
 */
public class Demo0079Exist {
    static boolean[][] used;
    public static boolean exist(char[][] board, String word) {
        // 二维数组,对搜索中使用过的元素做标记
        used = new boolean[board.length][board[0].length];
        boolean isExist;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    // 遍历二维网格,如果找到单词第一个字母,则以此为基准向四周推进搜索剩余字母
                    isExist = exist(board, word, 1, i, j);
                    // 找到一个匹配的可直接返回,否则继续遍历
                    if (isExist) return true;
                }
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, String word, int n, int i, int j) {
        // 单词索引越界,说明全部匹配,单词搜索完毕
        if (n >= word.length()) return true;
        // 搜索索引越界,该方向走不通
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (!used[i][j] && board[i][j] == word.charAt(n)) {
            used[i][j] = true; // 标记该元素已使用
            // 向四周递归查找剩余字母
            boolean isExist = exist(board, word, n+1, i+1, j)
                    || exist(board, word, n+1, i-1, j)
                    || exist(board, word, n+1, i, j+1)
                    || exist(board, word, n+1, i, j-1);
            if (isExist) {
                return true;
            }else {
                // 如果该方向走不通则将元素已使用的标记去除
                used[i][j] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        exist(board, word);
    }
}
