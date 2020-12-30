package cn.itdf.B_normal;

/**
 * 题目：在排序数组中查找元素的第一个和最后一个位置
 *
 * 思路：
 *      一、二分查找找到其中一个目标值后向两边遍历
 *
 *      二、二分查找目标值第一个二和第二个位置
 *          有两个版本，分别是我自己写的和网上大牛写的
 *
 * 二分查找的两种写法：
 *      while判断条件 <=  +  左右边界都需要 mid+1/mid-1
 *      while判断条件 <   +  左边界mid+1，右边界mid
 *
 *      原理：数组[0, 1]， mid = 0，
 *          < 的情况下， 左边界mid+1可以保证范围一直在缩小，避免死循环；右边界mid实际上也在缩小范围并且可以跳出循环，所以不需要再-1
 *          <=的情况下， 如果右边界还是 Mid， 则很可能导致死循环
 *
 */
public class Demo0034SearchRange {
    public static int[] searchRange(int[] nums, int target) {
//        return new int[] {search(nums, target, 0, nums.length-1, false), search(nums, target, 0, nums.length-1, true)};

        // 以下是大牛的解法
        // 第一个位置的二分查找很常规
        int a = search(nums, target);
        /**
         * 第二个位置的二分查找是通过找target + 1来实现
         * 因为 search 的结构默认就是找第一个位置，所以这里要先找target + 1
         * 即使数组中没有target + 1也能找到大致正确的位置
         *
         */
        /*
        第二个位置的二分查找是通过找target + 1来实现
        因为 search 的结构默认就是找第一个位置，所以这里要先找target + 1
        即使数组中没有target + 1也能找到大致正确的位置
         */
        // 第二个位置的二分查找是通过找target + 1来实现的。因为 search 的结构默认就是找第一个位置，所以这里要先找target + 1
        int b = search(nums, target + 1);
        // 考虑不存在目标值的情况
        if (a == nums.length || nums[a] != target) {
            return new int[] {-1, -1};
        }
        // 返回 a 和 b-1  (因为b找的是+1的位置)
        return new int[] {a, b-1};
    }

    /**
     * 网上大牛亲传
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) { // 左闭右开
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            }else {
                r = mid; // 因为这里包含等于和大于的情况，所以不-1
            }
        }
        return l; // 获取的是target所在第一个位置
    }

    /**
     * 这是自己写的方法，也能完成任务，但是判断条件比较多整体不算很优雅
     * @param nums
     * @param target
     * @param l 左边界
     * @param r 右边界
     * @param isEnd 是否找末尾的目标值
     * @return
     */
    public static int search(int[] nums, int target, int l, int r, boolean isEnd) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                // 1.mid 值小于 目标值
                // 1.1判断是否找第一个位置
                if (!isEnd) {
                    if (mid == r) {
                        // 1.1.1当 mid 值与右边界重合则没有满足要求的数
                        return -1;
                    }else if (nums[mid+1] == target) {
                        // 1.1.2当 mid 值右边的数等于目标值则找到了第一个位置
                        return mid + 1;
                    }
                }
                // 1.2其他情况下全部是左边界右移
                l = mid + 1;
            }else if (nums[mid] > target) {
                // 2.mid 值大于 目标值
                if (isEnd) {
                    if (mid == l) {
                        return -1;
                    }else if (nums[mid-1] == target) {
                        return mid - 1;
                    }
                }
                r = mid - 1;
            }else {
                // 3.mid 值等于 目标值
                if (!isEnd && (mid == l || nums[mid-1] != target)) {
                    // 3.1mid值等于左边界/左边的数不等于target 则找到第一个位置
                    return mid;
                }else if (isEnd && (mid == r || nums[mid+1] != target)) {
                    // 3.2mid值等于右边界/右边的数不等于target 则找到最后一个位置
                    return mid;
                }else if (!isEnd) {
                    // 3.3找第一个位置则右边界左移
                    r = mid - 1;
                }else {
                    // 3.4
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        searchRange(new int[] {2, 2}, 2);
    }
}
