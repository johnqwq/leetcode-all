package cn.itdf.demo02;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目:最低票价
 *
 * 思路:
 *      一 记忆化搜索(日期变量型)
 *          倒着进行动态规划,所有的dp(i)只会被计算一次,不会增大时间复杂度
 *          不是出行日期,dpi = dpi+1
 *          出行日期,dpi = 三种情况下最小成本,即 dpi+1 + 日票钱 : dpi+7 + 周票钱 : dpi+30 + 月票钱
 *          (计算当前最小成本需要先得到后面的最小成本,所以前面的结果值实际上已经包含(考虑)了后面的结果)
 *
 *          时间复杂度：O(W)O(W)，其中 W = 365W=365 是旅行计划中日期的最大值，我们需要计算 WW 个解，而每个解最多需要查询 33 个其他的解，因此计算量为 O(3 * W)=O(W)O(3∗W)=O(W)
 *
 *      二 记忆化搜索（窗口变量型）
 *          这种方法更多的是对方法一的优化,在方法一中非出行日期会持续进行递归,而这一步可以被省略掉,
 *          即只遍历days中所有的出行日期
 *
 *          时间复杂度：O(N)O(N)，其中 NN 是出行日期的数量，我们需要计算 NN 个解，而计算每个解的过程中最多将指针挪动 3030 步，计算量为 O(30 * N)=O(N)O(30∗N)=O(N)。
 *
 */
public class Demo983MincostTickets {
    Integer[] count;
    int[] days, costs;
    Set<Integer> date = new HashSet<>();
    int[] durations = new int[] {1, 7, 30};

    /**
     * 方法一
     */
//    public int mincostTickets(int[] days, int[] costs) {
//        this.costs = costs;
//        count = new Integer[366];
//        for (int day : days) {
//            date.add(day);
//        }
//        return dp(1);
//    }
//
//    public int dp(int i) {
//        if (i > 365) {
//            return 0;
//        }
//        // 每个dpi只需计算一次,因此如果有值了可以直接取回
//        if (count[i] != null) {
//            return count[i];
//        }
//        if (date.contains(i)) {
//            // 出行日期则取三种情况下成本最小的那一个
//            count[i] = Math.min(Math.min(dp(i+1) + costs[0], dp(i+7) + costs[1]), dp(i+30) + costs[2]);
//        }else {
//            // 非出行日期则往后计算
//            count[i] = dp(i+1);
//        }
//        return count[i];
//    }

    /**
     * 方法二
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        count = new Integer[days.length];
        for (int day : days) {
            date.add(day);
        }
        return dp(0);
    }

    public int dp(int i) {
        if (i >= days.length) {
            return 0;
        }
        if (count[i] != null) {
            return count[i];
        }
        count[i] = Integer.MAX_VALUE;
        int j = i;
        for (int k = 0; k < 3; k++) {
            // 当j小于当前天数+k对应的天数时,表示已经拿着票不需要买票了,因此j++
            while (j < days.length && days[j] < days[i] + durations[k]) {
                j++;
            }
            // 比较三种情况下最小的成本(因此前面要先取MAX_VALUE)
            count[i] = Math.min(count[i], dp(j) + costs[k]);
        }
        return count[i];
    }
}
