package cn.itdf.B_normal;

import cn.itdf.base.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目: 不同的二叉搜索树 II
 *      这题目真让人长见识了
 *      看完题解才发现究极厉害
 *
 *      一颗树可以看做是根节点,左子树,右子树三个部件的组合
 *      要穷尽所有的二叉搜索树, 1...n中的每个数字都要充当一次根节点, 因而代码此处需要遍历
 *      以 i 为根节点, 左子树的序列范围是 1...i-1 , 右子树的序列范围是 i+1...n
 *      一个根节点确定的二叉搜索树可以拆解成求 左子树的可能集合 * 右子树的可能集合
 *      而二叉搜索树的左子树和右子树同样是二叉搜索树, 左子树的可能集合 = 根节点遍历 1...i-1
 *      即 ∑1...i-1 (左子树的可能集合 * 右子树的可能集合)
 *      因而问题可以拆解成求 ∑1...n (左子树的可能集合 * 右子树的可能集合)
 *
 *
 */
public class Q0095GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftTree;
                    node.right = rightTree;
                    result.add(node);
                }
            }
        }
        return result;
    }
}
