package cn.itdf.B_normal;

/**
 * 题目: 不同的二叉搜索树
 *      上一题的解题思路可以抽象出以下三个函数
 *      G(n): 长度为 nn 的序列能构成的不同二叉搜索树的个数。
 *      F(i, n): 以 i 为根、序列长度为 n 的不同二叉搜索树个数 (1≤i≤n)。
 *      G(n) = ∑1...n F(i, n)
 *
 *      再经过一轮推理,
 *      (当i固定时, 左子树G(i-1)和右子树G(n-i)的可能数与数值无关, 与长度有关, 因而G(n)的值可以通过动态规划求得)
 *      再结合上面三个函数, 则有
 *      G(n) = ∑1...n G(i-1)*G(n-i)
 *
 *
 */
public class Q0096NumTrees {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public int numTrees2(int n) {
        return numTrees(1, n);
    }

    /**
     * 还是按照上一题的解法来写的话时间就太"长"了
     * @param start
     * @param end
     * @return
     */
    public int numTrees(int start, int end) {
        if (start >= end) {
            return 1;
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            int left = numTrees(start, i - 1);
            int right = numTrees(i + 1 , end);
            count += left * right;
        }
        return count;
    }
}
