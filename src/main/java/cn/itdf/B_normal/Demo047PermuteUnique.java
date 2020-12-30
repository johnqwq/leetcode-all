package cn.itdf.B_normal;

import java.util.*;

/**
 * 题目：全排列 II
 *
 * 思路：
 *      回溯搜索 + 剪枝
 *
 *
 */
public class Demo047PermuteUnique {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        // 记录各个位置的元素的使用情况
        boolean[] used = new boolean[nums.length];
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> deque = new ArrayDeque<>();

        // 排序是剪枝的前提
        Arrays.sort(nums);
        backTrace(ret, nums, used, deque, 0);
        return ret;
    }

    public static void backTrace(List<List<Integer>> ret, int[] nums, boolean[] used, Deque<Integer> deque, int count) {
        // 凑齐后加进结果集里
        if (count == nums.length) {
            List<Integer> list = new ArrayList<>(deque);
            ret.add(list);
        }
        // 每次都从头开始遍历
        for (int i = 0; i < nums.length; i++) {
            // 根据记录查看当前元素是否已使用
            if (used[i]) {
                continue;
            }
            // 如果当前元素与前一个元素相同 且 前一个元素的记录为false（表示在深度优先搜索的过程中刚遍历完且已结束），则跳过
            // used[i-1]为true表示刚刚还在使用，与当前元素属于同一组合；为false表示已结束上个遍历过程，与当前元素是不同组合的相同层级地位
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }

            // 添加到组合中
            deque.add(nums[i]);
            // 记录使用情况，作用有二：1下一行的递归中可以跳过本次操作；2遇到重复元素可以判断是否可跳过
            used[i] = true;
            backTrace(ret, nums, used, deque, count+1);
            used[i] = false;
            deque.pollLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = permuteUnique(new int[]{2, 2, 1, 1});
        System.out.println(list);
    }
}
