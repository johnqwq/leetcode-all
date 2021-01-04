package cn.itdf.B_normal;

import cn.itdf.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目: 路径总和 III
 *      解法一: 直接递归, 每个节点分别作为开头和路径中的一个点去计算
 *
 *      解法二: 前缀和 + 递归
 *          前缀和: 有一组数A B C D E F G
 *              前缀和f(C) = A + B + C
 *              如果f(F) = f(C), 则有 f(F) - f(C) = D + E + F = 0
 *              如果要找到某个数列 D + E + F = target, 可以利用前缀和差 f(F) - f(C)
 *
 *
 *
 */
public class Demo0437PathSum {

    /**
     * 解法一
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        // 将树上的每个节点都作为路径开头去尝试
        return recurve(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int recurve(TreeNode root, int sum) {
        if (root == null) return 0;
        // 如果符合就+1, 否则+0 ; 然后继续递归(因为结果路径可以是包含关系,所以+1后还需要继续递归尝试)
        return (root.val == sum ? 1 : 0) + recurve(root.left, sum - root.val) + recurve(root.right, sum - root.val);
    }

    /**
     * 解法二
     */
    public int pathSum2(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        // 默认存在前缀和为0的路径
        map.put(0, 1);
        return recurve2(root, map, sum, 0);
    }

    public int recurve2(TreeNode root, Map<Integer, Integer> map, int target, int curSum) {
        if (root == null) return 0;
        int count = 0;
        // 计算当前节点前缀和
        curSum += root.val;
        // 尝试找到某个总数等于target的路径
        // 这里如果value等于1, 表示有一个前缀和符合,即有一条路径满足条件 ;
        // 如果value大于1,表示前面出现多个相等的前缀和f(x), 每个从 节点x 到 当前节点 的路径都满足条件
        count += map.getOrDefault(curSum - target, 0);

        // 当前前缀和数量计数 + 1
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        // 递归
        count += recurve2(root.left, map, target, curSum);
        count += recurve2(root.right, map, target, curSum);

        // 去除当前节点的前缀和
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);
        return count;
    }
}
