package cn.itdf.B_normal;

import cn.itdf.base.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目: 二叉树的层序遍历
 *      层序遍历的解法都有一个固定模板了
 *
 *
 *
 */
public class Q0102LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> m = new LinkedList<>();
        m.offer(root);
        while (!m.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            // 一开始这里还是写的while ,  新增的元素只能存到另一个queue, 看了官方解析发现可以用size来规避
            int size = m.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = m.poll();
                list.add(node.val);
                if (node.left != null) {
                    m.offer(node.left);
                }
                if (node.right != null) {
                    m.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
