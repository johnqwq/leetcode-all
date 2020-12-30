package cn.itdf.demo02;

/**
 * 题目:颜色分类
 *
 * 思路:
 *      一 一次遍历
 *          需要将0和2分别放到数组左右两端,因此需要两个指针记录位置
 *          同时中间的数字可能藏着0/2,因此需要第三个指针来寻找(或者说需要第三个指针来遍历整个数组)
 *
 *
 *
 */
public class Demo075SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 1) return;
        // 左右指针 和 寻找指针
        int l = 0, curr = 0;
        int r = nums.length - 1;
        while (curr < r) {
            if (nums[curr] == 0) {
                // 找到0,和左指针交换(同一位置也没关系)
                int temp = nums[l];
                // 交换的同时左指针和寻找指针都前进
                nums[l++] = nums[curr];
                nums[curr++] = temp;
            }else if (nums[curr] == 2) {
                // 找到2,和右指针交换
                int temp = nums[curr];
                // 交换之后只有右指针前进(因为右指针交换过来的元素没有处理过,需要停留一次来判断处理)
                nums[curr] = nums[r];
                nums[r--] = temp;
            }else {
                // 找到1,可跳过
                curr++;
            }
        }
    }
}
