package cn.itdf.B_normal;

import cn.itdf.base.TreeNode;

/**
 * 题目: 二叉树展开为链表
 *      做多了树会发现一般有两种解题思路, 深度优先和广度优先
 *      这题明显不能用广度优先, 因而尝试深度优先的方法比如迭代
 *      将根节点的问题拆解为叶子节点的问题
 *
 */
public class Q0114Flatten {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        TreeNode rightNode = dfs(root.right);
        TreeNode leftNode = dfs(root.left);
        if (leftNode != null) {
            root.right = leftNode;
            if (rightNode != null) {
                while (leftNode.right != null) {
                    leftNode = leftNode.right;
                }
                leftNode.right = rightNode;
            }
        }
        // 左子树及时剪掉
        root.left = null;
        return root;
    }
}
