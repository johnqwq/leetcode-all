package cn.itdf.B_normal;

import cn.itdf.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树迭代器
 */
public class Demo0173BSTIterator {

    Queue<Integer> queue = new LinkedList<>();

    public Demo0173BSTIterator(TreeNode root) {
        save(root);
    }

    private void save(TreeNode root) {
        if (root == null) return;
        save(root.left);
        queue.add(root.val);
        save(root.right);
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return queue.peek() != null;
    }

}
