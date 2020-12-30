package cn.itdf.demo02;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 题目:旋转链表
 *
 * 思路:
 *      找到旋转位置(断裂处)
 *      普通情况一个双指针搞定,但是为了解决k值较大的情况(循环走多圈耗时厉害),这里右指针先走一遍获取链表长度
 *      而后再对k取模去除多余的操作
 *
 *
 */
public class Demo061RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode l = head;
        ListNode r = head;
        // 获取链表的长度
        int n = 1;
        while (r.next != null) {
            r = r.next;
            n++;
        }
        // 左指针走到旋转位置
        for (int i = 0; i < n - k % n - 1; i++) {
            l = l.next;
        }
        r.next = head;
        head = l.next;
        l.next = null;
        return head;
    }
}
