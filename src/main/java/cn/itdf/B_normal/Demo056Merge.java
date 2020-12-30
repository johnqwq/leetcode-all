package cn.itdf.B_normal;

/**
 * 题目:合并区间
 *
 * 思路:
 *      一 排序 + 右侧元素比较
 *
 *      二 不排序 + 左右元素同时比较 + 遍历
 *
 */
public class Demo056Merge {
    /**
     * 网上大牛的代码,思路比较好理解,,缺点是时间消耗比较高
     * @param intervals
     * @return
     */
//    public int[][] merge(int[][] intervals) {
//        if (intervals.length < 2) {
//            return intervals;
//        }
//
//        // 先对数组进行排序
////        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
//        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
//        int[][] ret = new int[intervals.length][2];
//        int idx = -1;
//        // 遍历比较
//        for (int[] interval : intervals) {
//            if (idx == -1 || ret[idx][1] < interval[0]) {
//                ret[++idx] = interval;
//            }else {
//                ret[idx][1] = Math.max(ret[idx][1], interval[1]);
//            }
//        }
//        // 复制数组
//        return Arrays.copyOf(ret, idx+1);
//    }

    /**
     * 网上大牛的代码二,优点是不需要排序,速度非常快,思路也比较好理解没啥缺点
     * 虽然有双重循环,但可能是因为不需要先排序,所以还是比上面的方法快
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;

        // 记录合并次数
        int count = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i+1; j < intervals.length; j++) {
                // 下面这行代码判断出了所有可以合并的情况
                // (可以概况为:两个数组的右端点都大于对方的左端点,
                // 例如[1, 3] [2, 4] 和 [2, 4] [1, 3],两个数组交换位置不影响结果)
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                    // 由于不确定哪个数组的左端点最小,于是要先判断;右端点同理
                    intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
                    intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
                    count++;
                    intervals[i] = null;
                    // 交换一次过后当前i更新成j,因此后面从i+1开始比较
                    break;
                }
            }
        }

        // 根据合并次数重新生成新的数组
        int[][] ret = new int[intervals.length - count][2];
        int idx = 0;
        for (int[] interval : intervals) {
            if (interval != null) {
                ret[idx++] = interval;
            }
        }
        return ret;
    }
}
