package cn.itdf.B_normal;

/**
 * 题目：搜索旋转排序数组
 *
 * 思路：
 *      同样是思路比较重要的题目
 *      解题的关键是利用好 mid 值左右两部分数组一定有一个是升序的，然后借此判断 target 是否在其中，从而缩小查询边界
 *      由于我们判断的入口是升序数组，因而即使给定数组没有旋转或者边界缩小变成完全升序数组之后也适用
 *
 *
 */
public class Demo033Search {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] >= nums[l]) { // 注意这里的等号是因为中值可能和左边界重叠
                // 1.当左半部分是升序的
                if (target >= nums[l] && target < nums[mid]) { // 注意这里的等号是因为 target 也可能和边界重叠
                    // 1.1如果 target 在左边界与中值中间，则右边界往左移；反之左边界右移
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {
                // 2.当右半部分是升序的
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        // 3.找不到说明没有
        return -1;
    }
}
