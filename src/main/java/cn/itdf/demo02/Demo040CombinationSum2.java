package cn.itdf.demo02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 题目：组合总和 II
 *
 * 思路：
 *      依然是回溯算法+剪枝
 *
 *      区别是本题不可以重复使用元素，
 *      需要解决两个点：
 *          [1, 1, 2, 5, 6]
 *          同层级元素不能相同       比如 1 2 5 / 1 2 5
 *          不同层级元素可以相同      比如 1 1 6
 *
 */
public class Demo040CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        // 先进行排序，方便剪枝
        Arrays.sort(candidates);
        // 用栈作为存储容器
        combination(ret, new Stack<>(), candidates, 0, target);
        return ret;
    }

    public void combination(List<List<Integer>> ret, Stack<Integer> stack, int[] candidates, int index, int target) {
        // 当target刚好等于0说明当前组合是有效解
        if (target == 0) {
            ret.add(new ArrayList<>(stack));
            return;
        }

        // 从前往后遍历
        for (int i = 0; i < candidates.length; i++) {
            // 下面这三行就是本题的核心代码。
            // 当i > index，说明当前元素与前一个元素同层级，因此相同时需跳过
            // 当i = index，说明当前元素与前一个元素不同层级（新的递归的初始），因此相同时不用跳过
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }

            // 当前元素已经偏大了则后面也没有适合的元素了，应当剪枝
            if (candidates[i] > target) {
                break;
            }
            // 第i个元素是有效的，递归求解
            stack.push(candidates[i]);
            combination(ret, stack, candidates, i, target - candidates[i]);
            // 上面递归完成后回来要先pop，目的是去除前面的组合的遗留元素
            stack.pop();
        }
    }
}