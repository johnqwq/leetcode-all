package cn.itdf.demo01;

/**
 * 题目：验证回文串
 *      给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 思路：
 *      用字符API的话确实很快，而且代码也很简洁
 *      但是确保自己不用API也能做出来相对也是比较重要的
 *
 */
public class Demo125IsPalindrome {
    /**
     * API做法
     * @param s
     * @return
     */
    /*
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            while (i <= j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i <= j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (i <= j) {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            }
        }
        return true;
    }
    */

    /**
     * ASCII做法
     * 不用API而用原始ASCII的优势就是快！好快！
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char ic = s.charAt(i), jc = s.charAt(j);
            if (ic == jc) {
                i++;
                j--;
            }else if (ic < '0' || (ic > '9' && ic < 'A') || (ic > 'Z' && ic < 'a') || ic > 'z') {
                i++;
            }else if (jc < '0' || (jc > '9' && jc < 'A') || (jc > 'Z' && jc < 'a') || jc > 'z') {
                j--;
            }else if (ic > '9' && jc > '9' && Math.abs(ic - jc) == 32) {
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((char) 48);
        System.out.println((char) 65);
        System.out.println((char) 97);
    }
}
