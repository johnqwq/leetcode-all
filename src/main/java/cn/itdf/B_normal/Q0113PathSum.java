package cn.itdf.B_normal;

import cn.itdf.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q0113PathSum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSum(root, sum, new Stack<>());
        return result;
    }

    public void pathSum(TreeNode root, int sum, Stack<Integer> stack) {
        if (root == null) return;
        stack.push(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                result.add(new ArrayList<>(stack));
                stack.pop();
                return;
            }
        }
        pathSum(root.left, sum - root.val, stack);
        pathSum(root.right, sum - root.val, stack);
        stack.pop();
    }
}
