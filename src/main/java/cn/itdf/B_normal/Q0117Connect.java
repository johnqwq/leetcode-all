package cn.itdf.B_normal;

import cn.itdf.base.Node;

public class Q0117Connect {
    public Node connect(Node root) {
        if (root == null) return root;
        Node leftMost = root;
        while (leftMost.left != null) {
            Node head = leftMost;
            while (head != null) {
                Node node = null;
                if (head.right != null) {
                    if (head.left != null) {
                        head.left.next = head.right;
                    }
                    node = head.right;
                }else if (head.left != null) {
                    node = head.left;
                }
                Node tempNode = head;
                while (node != null && node.next == null && tempNode.next != null) {
                    tempNode = tempNode.next;
                    if (tempNode.left != null) {
                        node.next = tempNode.left;
                    }else if (tempNode.right != null) {
                        node.next = tempNode.right;
                    }
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
