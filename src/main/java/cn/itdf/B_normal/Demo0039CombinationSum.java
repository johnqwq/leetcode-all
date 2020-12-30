package cn.itdf.B_normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 题目：组合总和
 *
 * 思路：
 *      回溯算法+剪枝
 *
 *      回溯算法解决答案元素的存储问题
 *      剪枝提高性能
 *
 *
 */
public class Demo0039CombinationSum {
    /**
     * 这是我自己的一个思路，从后往前查找（从官方测试时间来看比下面的从前往后要慢一点，原因没想明白，待解决）
     * @param candidates
     * @param target
     * @return
     */
    /*
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        combination(ret, new Stack<>(), candidates, candidates.length-1, target);
        return ret;
    }

    public void combination(List<List<Integer>> ret, Stack<Integer> stack, int[] candidates, int index, int target) {
        if (target == 0) {
            ret.add(new ArrayList<>(stack));
            return;
        }

        for (int i = index; i >= 0; i--) {
            if (candidates[i] <= target) {
                stack.push(candidates[i]);
                combination(ret, stack, candidates, i, target-candidates[i]);
                stack.pop();
            }
        }
    }
    */

    /**
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            // 当前元素已经偏大了则后面也没有适合的元素了，应当剪枝
            if (candidates[i] > target) {
                break;
            }
            // 第i个元素是有效的，递归求解
            stack.push(candidates[i]);
            combination(ret, stack, candidates, i, target-candidates[i]);
            // 上面递归完成后回来要先pop，目的是去除前面的组合的遗留元素
            stack.pop();
        }
    }
}
