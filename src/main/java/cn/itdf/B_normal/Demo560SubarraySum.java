package cn.itdf.B_normal;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目:和为K的子数组
 *
 * 思路:
 *      一 枚举
 *
 *      二 前缀和 + 哈希表优化
 *
 *
 */
public class Demo560SubarraySum {
    /**
     * 枚举法,非常暴力
     * @param nums
     * @param k
     * @return
     */
    /*
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }
    */

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) count += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
