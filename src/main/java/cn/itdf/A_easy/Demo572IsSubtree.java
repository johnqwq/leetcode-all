package cn.itdf.A_easy;

/**
 * 题目:另一个树的子树
 *
 * 思路:
 *      递归
 *          遍历主树
 *          碰到头结点相同的情况,放到递归链中逐个匹配(但不能直接返回,失败了也只是这个头结点失败了)
 *
 */
public class Demo572IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return sub(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean sub(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return s.val == t.val && sub(s.left, t.left) && sub(s.right, t.right);
    }
}
