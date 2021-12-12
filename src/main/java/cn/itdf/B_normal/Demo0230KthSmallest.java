package cn.itdf.B_normal;

import cn.itdf.base.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo0230KthSmallest {

    Deque<Integer> deque = new ArrayDeque<>();

    public int kthSmallest(TreeNode root, int k) {
        if (root.left != null) {
            int ret = kthSmallest(root.left, k);
            if (ret != -1) return ret;
        }
        ;
        deque.add(root.val);
        if (deque.size() == k) return deque.pollLast();
        if (root.right != null) {
            int ret = kthSmallest(root.right, k);
            if (ret != -1) return ret;
        }
        return -1;
    }

}
