package cn.itdf.demo02;

public class Demo080RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length < 3) return nums.length;
        int i = 2;
        for (int num : nums) {
            if (num > nums[i-2]) nums[i++] = num;
        }
        return i;
    }
}
