package cn.itdf.B_normal;

/**
 * 题目: 删除排序数组中的重复项 II
 *      这里直接就是拿的官方的解法
 *      有一点小缺陷是在后面所有元素都一样的情况下没有删除重复的元素, 而只是返回了正确的长度
 *
 *
 */
public class Demo0080RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count += 1;
            }else {
                count = 1;
            }

            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
