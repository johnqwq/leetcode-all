package cn.itdf.B_normal;

import cn.itdf.base.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Q0094InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }

    public void dfs(TreeNode root, List<Integer> result) {
        if (root == null) return;
        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
    }
}
