package cn.itdf.demo01;

import java.util.Stack;

/**
 * 题目:最小栈
 *
 * 思路:
 *      一 辅助栈
 *          官方给的解法,不过是对栈的一个封装,不算特别符合做题要求
 *          栈的一个特点就是只要知道入栈顺序,那么看到栈顶就能推断出栈内的所有元素
 *          放到最小值这里也适用,可以使用一个辅助栈，与元素栈同步插入与删除，用于存储与每个元素对应的最小值
 *      二 链表
 *          这个方法的内核和上面的一样,只不过形式从辅助栈换成了链表结点的一个成员变量
 *          更符合题目要求,而且速度也更快
 *
 *
 */

/**
 * 链表
 */
class MinStack {
    Node head;

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        }else {
            head = new Node(x, head, Math.min(x, head.min));
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    class Node {
        int val;
        Node next;
        int min;

        private Node(int val, int min) {
            this(val, null, min);
        }

        private Node(int val, Node next, int min) {
            this.val = val;
            this.next = next;
            this.min = min;
        }
    }
}


/**
 * 辅助栈
 */
/*
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.size() < 1) {
            min.push(x);
        }else if (x < min.peek()) {
            min.push(x);
        }else {
            min.push(min.peek());
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
*/

public class Demo155MinStack {

}


