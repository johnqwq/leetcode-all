package cn.itdf.B_normal;

public class Demo081Search {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target && target >= nums[l]) {
                r = mid;
            }else if (nums[mid] < target && target <= nums[r]) {
                l = mid + 1;
            }else if (nums[mid] == target) {
                return true;
            }
        }
        return false;
    }
}
