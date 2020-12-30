package cn.itdf.demo02;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：全排列
 *
 * 思路：
 *      回溯法
 *
 */
public class Demo046Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backTrace(ret, nums, 0);
        return ret;
    }

    public void backTrace(List<List<Integer>> ret, int[] nums, int first) {
        if (first == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            ret.add(list);
        }
        for (int i = first; i < nums.length; i++) {
            swap(nums, first, i);
            backTrace(ret, nums, first+1);
            swap(nums, first, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
