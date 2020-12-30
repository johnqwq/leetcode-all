package cn.itdf.demo01;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目:快乐数
 *
 * 思路:
 *      关键在于找到环
 *
 *      一 用 HashSet
 *
 *      二 快慢指针法
 *
 */
public class Demo202IsHappy {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            if (n == 1) return true;
            // 记录下一个数字
            int temp = 0;
            do {
                temp += Math.pow(n % 10, 2);
                n /= 10;
            }while (n > 0);
            n = temp;
        }
        return false;
    }

    public static void main(String[] args) {
        isHappy(19);
    }
}
