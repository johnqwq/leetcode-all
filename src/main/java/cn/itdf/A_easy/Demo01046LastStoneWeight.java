package cn.itdf.A_easy;

import java.util.PriorityQueue;

/**
 * 题目: 最后一块石头
 *      每次寻找最重的两块石头相撞粉碎, 取剩余重量 a- b 或者 0;
 *      返回 最后剩余的石头重量 或者 0
 *
 *      这个题目的解法只是利用了最大堆数据结构的优势, 本身代码没有可称赞的地方
 */
public class Demo01046LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : stones) {
            pq.offer(num);
        }
        while (pq.size() > 1) {
            Integer a = pq.poll();
            Integer b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
