package cn.itdf.B_normal;

public class Demo0331IsValidSerialization {
    public boolean isValidSerialization(String preorder) {
        // 出现#表示剪枝
        int ret = valid(preorder, 0);
        return ret != -1 && ret >= preorder.length();
    }

    public int valid(String preorder, int i) {
        // 当前索引越界就不及格
        if (i >= preorder.length()) return -1;
        char cur = preorder.charAt(i);
        // 当前节点是#就直接剪枝
        if ('#' == cur) return i + 2;
        // 要先跳过当前节点其他数字从而找到左子树根节点（第一个逗号的右边就是左子树根节点）
        do {
            i++;
        } while (i < preorder.length() && ',' != preorder.charAt(i));
        // 校验左右节点是否能重构一棵树
        int ret = valid(preorder, i + 1);
        if (ret == -1) return -1;
        int rightIndex = ret;
        ret = valid(preorder, rightIndex);
        return ret == -1 ? -1 : ret;
    }
}
