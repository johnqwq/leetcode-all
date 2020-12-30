package cn.itdf.B_normal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Demo0078Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= nums.length; i++) {
            subsets(ret, deque, nums, 0, i);
        }
        return ret;
    }

    public void subsets(List<List<Integer>> ret, Deque<Integer> deque, int[] nums, int index, int n) {
        if (n < 1) {
            ret.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            deque.add(nums[i]);
            subsets(ret, deque, nums, i+1, n-1);
            deque.pollLast();
        }
    }
}
