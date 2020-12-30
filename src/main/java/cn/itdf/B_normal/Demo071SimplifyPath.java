package cn.itdf.B_normal;

/**
 * 题目: 简化路径
 *
 * 思路:
 *      一 倒序遍历
 *          程序处理这样的问题难点,如果顺序遍历,难点在于碰到..后需要回去处理已处理过的元素
 *          一种解决办法就是倒序遍历,遇到..的话那下一个碰到的元素可以不用处理直接跳过
 *      二 栈
 *          另一种解决办法就是用栈,需要的时候入栈,碰到..则弹出一个元素,因而也能保持文件路径的准确
 *
 *
 */
public class Demo071SimplifyPath {
    /**
     * 倒序遍历
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        StringBuilder builder = new StringBuilder();
        int jump = 0;
        String[] arr = path.split("/");
        for (int i = arr.length - 1; i >= 0; i--) {
            // 遇到干扰字符直接跳过
            if ("".equals(arr[i]) || "/".equals(arr[i]) || ".".equals(arr[i])) continue;
            // 碰到..作记录,下一个(非干扰)元素可直接跳过
            if ("..".equals(arr[i])) {
                jump++;
                continue;
            }
            if (jump > 0) {
                jump--;
                continue;
            }
            // 记录文件路径
            builder.insert(0, arr[i]);
            builder.insert(0, "/");
        }
        if (builder.length() < 1) {
            return "/";
        }else {
            return builder.toString();
        }
    }
}
