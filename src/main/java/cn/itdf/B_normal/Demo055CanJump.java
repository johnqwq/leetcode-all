package cn.itdf.B_normal;

/**
 * 题目：跳跃游戏
 *
 * 思路：
 *      一 贪心算法
 *          从前往后遍历，计算每次能达到的最远位置且随时更新，如果最大值过不去某个位置则失败
 *
 *      二 自己写的这个
 *          游戏失败的地方在于数组中存在0且前面的元素没有能跳过这个0的
 *          因此只要找到0再查看是否能处理掉就完事
 *
 *
 *
 */
public class Demo055CanJump {
    /**
     * 自己的思路，从后往前遍历，遇到0则处理，处理不掉则失败，遍历完成且处理成功则游戏胜利
     * @param nums
     * @return
     */
//    public boolean canJump(int[] nums) {
//        // 假设数组中没有0
//        boolean flag = true;
//        int count = 0;
//        for (int i = nums.length - 2; i >= 0; i--) {
//            if (flag) {
//                if (nums[i] != 0) {
//                    // 不等于0则跳过
//                    continue;
//                }else {
//                    // 等于0则需要处理
//                    flag = false;
//                }
//            }else {
//                // 每往前走一步都++
//                count++;
//                if (count - nums[i] < 0) {
//                    // 如果对应的数字大于当前count说明可以跳过那个0，因此flag重置
//                    flag = true;
//                    count = 0;
//                }
//            }
//        }
//        return flag && count == 0;
//    }

    /**
     * 网友的思路，原理就是贪心算法
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                return false;
            }
            k = k > i + nums[i] ? k : i + nums[i];
        }
        return true;
    }
}
