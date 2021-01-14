package cn.itdf.A_easy;

/**
 * 题目: 路径总和
 *      有深度优先和广度优先两种解法
 *
 *
 *
 */
public class Q0112HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum - root.val == 0;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
