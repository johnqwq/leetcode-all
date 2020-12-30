package cn.itdf.demo02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 题目:组合
 *      给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 思路:
 *      一 回溯法
 *
 *
 */
public class Demo077Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        combine(ret, deque, 1, n, k);
        return ret;
    }

    /**
     * 回溯法
     * @param ret
     * @param deque
     * @param index
     * @param n
     * @param k
     */
    public void combine(List<List<Integer>> ret, Deque<Integer> deque, int index, int n, int k) {
        if (deque.size() == k) {
            ret.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index; i <= n; i++) {
            // 当加上剩余元素都不够k个则剪枝,这一步对于加快速度至关重要
            if (deque.size() + n - i + 1 < k) return;
            deque.add(i);
            // 递归获取剩余不同的元素进行组合
            combine(ret, deque, i+1, n, k);
            deque.pollLast();
        }
    }
}
