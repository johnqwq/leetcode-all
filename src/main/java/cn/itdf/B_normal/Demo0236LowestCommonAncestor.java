package cn.itdf.B_normal;

import cn.itdf.base.TreeNode;

public class Demo0236LowestCommonAncestor {

    TreeNode ret = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p, q);
        return ret;
    }

    public boolean search(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean leftRet = search(root.left, p, q);
        if (ret != null) return false;
        boolean rightRet = search(root.right, p, q);
        if (ret != null) return false;
        boolean currentRet = root.val == p.val || root.val == q.val;
        if (currentRet && (leftRet || rightRet)) {
            ret = root;
        } else if (leftRet && rightRet) {
            ret = root;
        }
        return leftRet || currentRet || rightRet;
    }
}
