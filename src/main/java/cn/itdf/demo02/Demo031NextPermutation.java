package cn.itdf.demo02;

import java.util.Arrays;

/**
 * 题目：下一个排列。找到给定的数字序列的所有可能的排列中的下一个更大的排列
 *
 * 思路：
 *      这道题的关键是数学分析，明白题目对应的数学逻辑就好写了
 *
 *      条件：
 *          1 当序列为完全逆序时，没有下一个更大的排列
 *          2 从右往左找，第一个比右边小的数 i 就是交换的起点
 *          3 将当前数字 i 与右边的从右往左找第一个比当前数字大的数 j 交换
 *          4 再将当前数字 i 右边的序列顺序排列
 *
 */
public class Demo031NextPermutation {
    public void nextPermutation(int[] nums) {
        int L = nums.length;
        // 2 从右往左找，第一个比右边小的数 i 就是交换的起点
        for (int i = L-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                // 3 将当前数字 i 与右边的从右往左找第一个比当前数字大的数 j 交换
                int j = L-1;
                while (nums[j] <= nums[i]) {
                    j--;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                // 4 再将当前数字 i 右边的序列顺序排列
                i++;
                j = L - 1;
                while (i < j) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                }
                return;
            }
        }
        // 1 当序列为完全逆序时，没有下一个更大的排列
        Arrays.sort(nums);
    }
}
