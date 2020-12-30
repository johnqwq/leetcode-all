package cn.itdf.B_normal;

/**
 * 题目：每日温度
 *  请根据每日 气温 列表，重新生成一个列表。
 *  对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 *  如果气温在这之后都不会升高，请在该位置用 0 来代替
 *
 * 思路：
 *      一 暴力
 *          从后往前遍历。
 *          以温度为索引，位置索引为值，存储到另一个数组中
 *          在数组中找比当前温度要高的温度的值，该值即是最小索引
 *
 *          时间复杂度：O(nm)，其中 n 是温度列表的长度，m 是数组 next 的长度，在本题中温度不超过 100，所以 m 的值为 100。反向遍历温度列表一遍，对于温度列表中的每个值，都要遍历数组 next 一遍
 *
 *      二 单调栈
 *          维护一个存储下标的单调栈
 *          单调栈满足从栈底到栈顶元素对应的温度递减，
 *          因此每次有元素进栈时，会将温度更低的元素全部移除，并更新出栈元素对应的等待天数，
 *          这样可以确保等待天数一定是最小的
 *
 *      三 从后往前遍历，利用已知信息（网友解法，贼强）
 *          1.找i元素时，先比较j（i+1）元素，如果 i<j 则j是目标值
 *          2.否则查看res[j]，如果为0说明i元素目标值也为0（经过1.的筛选j必定小于等于i，j都找不到更高温度则i也没有）
 *          3.如果res[j]不为0则j+=res[j]，继续进行1.的比较（这一步也跳过了许多检验，大大节省时间）
 *
 *          该方法的二三步节省了非常多的时间，剪枝能力甲级
 *
 */
public class Demo0739DailyTemperatures {

    /**
     * 暴力解法
     * @param T
     * @return
     */
    /*
    public int[] dailyTemperatures(int[] T) {
        int L = T.length;
        int[] ret = new int[L];
        int[] search = new int[101];
        Arrays.fill(search, Integer.MAX_VALUE);
        for (int i = L - 1; i >= 0; i--) {
            int index = Integer.MAX_VALUE;
            for (int j = T[i] + 1; j <= 100; j++) {
                // 找到数组中比 T[i] 温度更高的元素，取出索引
                if (search[j] < index) index = search[j];
            }
            // 如果取到的索引小于Integer.MAX_VALUE说明存在更高的温度，可以更新ret
            if (index < Integer.MAX_VALUE) ret[i] = index - i;
            // 将当前温度放入search中以供前面的温度查找
            search[T[i]] = i;
        }
        return ret;
    }
    */

    /**
     * 单调栈
     * @param T
     * @return
     */
    /*
    public int[] dailyTemperatures(int[] T) {
        int[] ret = new int[T.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            int temperature = T[i];
            // 判断单调栈内是否有元素且栈顶元素温度是否小于当前温度
            while (!stack.isEmpty() && T[stack.peek()] < temperature) {
                // 是则说明找到了更高的温度，此时出栈
                int t = stack.pop();
                //出栈的同时标记该温度对应的目标值
                ret[t] = i - t;
            }
            stack.push(i);
        }
        return ret;
    }
    */

    /**
     * 从后往前遍历，利用已知信息
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = T.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < T.length) {
                if (T[j] > T[i]) {
                    // 1.找i元素时，先比较j（i+1）元素，如果 i<j 则j是目标值
                    res[i] = j - i;
                    break;
                }else if (res[j] == 0) {
                    // 2.否则查看res[j]，如果为0说明i元素目标值也为0（经过1.的筛选j必定小于等于i，j都找不到更高温度则i也没有）
                    res[i] = 0;
                    break;
                }else {
                    // 3.如果res[j]不为0则j+=res[j]，继续进行1.的比较（这一步也跳过了许多检验，大大节省时间）
                    j += res[j];
                }
            }
        }
        return res;
    }
}
