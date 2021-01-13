package cn.itdf.A_easy;

import java.util.LinkedList;
import java.util.Queue;

public class Q0111MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // 这里记录深度最好也不要改变原来的数据, 可以用一个内部类包装,  或者用一个遍历记录循环层数
        root.val = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                return node.val;
            }
            if (node.left != null) {
                node.left.val = node.val + 1;
                queue.offer(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val + 1;
                queue.offer(node.right);
            }
        }
        return -1;
    }
}
