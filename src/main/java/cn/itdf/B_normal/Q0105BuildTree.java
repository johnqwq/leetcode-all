package cn.itdf.B_normal;

import cn.itdf.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q0105BuildTree {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int head, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(inorder[start]);
        int val = preorder[head];
        TreeNode node = new TreeNode(val);
        Integer index = map.get(val);
        node.left = buildTree(preorder, inorder, head + 1, start, index - 1);
        node.right = buildTree(preorder, inorder, head + 1 + (index - start), index + 1, end);
        return node;
    }
}
