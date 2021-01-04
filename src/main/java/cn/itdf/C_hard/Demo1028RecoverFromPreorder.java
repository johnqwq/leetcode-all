package cn.itdf.C_hard;

import cn.itdf.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 题目：从先序遍历还原二叉树
 *  尝试的第一道困难题，但没做出来
 *
 * 思路：
 *      方法一：迭代
 *
 *      (方法二：递归。
 *      这道题同样能用递归来做，但不可避免地需要设置全局变量来表示“字符串处理的位置”或者“当前深度”。
 *      暂不考虑)
 *
 *
 */
public class Demo1028RecoverFromPreorder {
    public TreeNode recoverFromPreorder(String S) {
        // 用一个栈来模拟递归和回溯
        Deque<TreeNode> path = new LinkedList<>();
        int pos = 0;
        while (pos < S.length()) {
            int level = 0;
            while (S.charAt(pos) == '-') {
                // 当碰到横杠时持续移动
                pos++;
                // 记录当前数字对应的深度
                level++;
            }
            // 获取当前数字
            int value = 0;
            while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + S.charAt(pos) - '0';
                pos++;
            }
            TreeNode node = new TreeNode(value);
            if (path.size() == level) {
                // 如果当前数字的深度和栈的长度一致，则挂靠为左子节点
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            }else {
                // 如果当前数字的深度和栈的长度不一致，则先弹出元素到长度一致再挂靠为右子节点
                while (path.size() != level) {
                    path.pop();
                }
                path.peek().right = node;
            }
            // 添加当前数字到栈中（因为有可能是后面节点的父节点）
            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }
}
