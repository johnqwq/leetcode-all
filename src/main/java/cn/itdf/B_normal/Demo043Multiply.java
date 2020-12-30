package cn.itdf.B_normal;

/**
 * 题目：字符串相乘
 *
 * 思路：
 *      优化竖式（模拟小学乘法的手写运算）
 *
 */
public class Demo043Multiply {
    public String multiply(String num1, String num2) {
        // 乘数为0返回0
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        // 存放计算结果的数组
        int[] ret = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            // 遍历获取各个字符对应的数字
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                // 进行计算
                int sum = ret[i + j + 1] + n1 * n2;
                // 在对应位置放置计算结果
                ret[i + j + 1] = sum % 10;
                ret[i + j] += sum / 10;
            }
        }

        // 遍历计算结果取出
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ret.length; i++) {
            // 开头有可能为0需要判断一下
            if (i == 0 && ret[i] == 0) {
                continue;
            }
            builder.append(ret[i]);
        }
        return builder.toString();
    }
}
