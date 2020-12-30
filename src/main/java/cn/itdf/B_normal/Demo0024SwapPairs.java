package cn.itdf.B_normal;

/**
 * 题目：两两交换链表中的节点
 *
 * 思路：
 *      一、迭代法
 *          时间复杂度：O(N)
 *          空间复杂度：O(1)
 *
 *      二、递归法
 *          时间复杂度：O(N)
 *          空间复杂度：O(N)，递归过程使用的堆栈空间
 *
 *          优点：形式简洁
 *
 */
public class Demo0024SwapPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre; // pre节点作记录用
        ListNode l = root;
        ListNode r;
        // 当 l 的下一个节点或下下个节点为空时不具备交换的条件
        while (l.next != null && l.next.next != null) {
            pre = l;
            l = l.next; // 移动就位
            r = l.next; // 移动就位

            // 交换细节
            l.next = r.next;
            r.next = l;
            pre.next = r;
        }
        return root.next;
    }

    /**
     * 递归法
     * @param head
     * @return
     */
//    public ListNode swapPairs(ListNode head) {
//        // 当前节点为空或者下一节点为空时不具备交换的条件，直接返回当前节点
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode l = head;
//        ListNode r = head.next;
//
//        l.next = swapPairs(r.next); // 递归交换 r 后面的节点，同时将返回的节点交给 l 完成本次交换
//        r.next = l;
//
//        return r;
//    }
}
