package cn.itdf.A_easy;

/**
 * 题目:加一
 *      把过程和边界条件捋顺写出来就已经是最优解了
 */
public class Demo0066PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
