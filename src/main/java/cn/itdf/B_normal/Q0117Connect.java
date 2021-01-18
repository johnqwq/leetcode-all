package cn.itdf.B_normal;

import cn.itdf.base.Node;

public class Q0117Connect {
    Node last, nextStart;

    public Node connect(Node root) {
        if (root == null) return root;
        Node head = root;
        while (head != null) {
            last = null;
            nextStart = null;
            for (Node node = head; node != null; node = node.next) {
                if (node.left != null) {
                    bfs(node.left);
                }
                if (node.right != null) {
                    bfs(node.right);
                }
            }
            head = nextStart;
        }
        return root;
    }

    public void bfs(Node node) {
        if (last != null) {
            last.next = node;
        }
        if (nextStart == null) {
            nextStart = node;
        }
        last = node;
    }
}
