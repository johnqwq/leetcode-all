package cn.itdf.B_normal;

import cn.itdf.base.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Q0116Connect {
    Queue<Node> queue = new LinkedList<>();

//    public Node connect(Node root) {
//        if (root == null) return root;
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            Node pre = null;
//            for (int i = 0; i < size; i++) {
//                Node node = queue.poll();
//                if (node.left != null) queue.offer(node.left);
//                if (node.right != null) queue.offer(node.right);
//                if (pre != null) pre.next = node;
//                pre = node;
//            }
//        }
//        return root;
//    }

    /**
     * 深度优先
     * @param root
     */
    public void dfs(Node root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            dfs(root.left);
            dfs(root.right);
        }
    }

    /**
     * 广度优先
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) return root;
        Node leftMost = root;
        // 最左节点的左节点为空则不需要继续操作
        while (leftMost.left != null) {
            Node head = leftMost;
            while (head != null) {
                // 链接当前节点的左右子节点
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // 去往当前节点的next节点
                head = head.next;
            }
            // 下一层的最左节点
            leftMost = leftMost.left;
        }
        return root;
    }
}
