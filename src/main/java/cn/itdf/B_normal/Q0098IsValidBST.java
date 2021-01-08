package cn.itdf.B_normal;

import cn.itdf.base.TreeNode;

/**
 * 题目: 验证二叉搜索树
 *      比较常规的递归题目
 *
 */
public class Q0098IsValidBST {
    /**
     * 这里用包装类还是不太好,   应该用 Integer.MIN_VALUE 这种去预填充的,  性能有提示同时也不影响逻辑正确
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root.left, null, root.val) && isValidBST(root.right, root.val, null);
    }

    public boolean isValidBST(TreeNode root, Integer greater, Integer less) {
        if (root == null) return true;
        if (greater != null && root.val <= greater) return false;
        if (less != null && root.val >= less) return false;
        return isValidBST(root.left, greater, root.val) && isValidBST(root.right, root.val, less);
    }
}
