package cn.itdf.B_normal;

import java.util.*;


/**
 * 题目：字母异位词分组
 *
 * 思路：
 *      一 排序数组分类
 *          当且仅当它们的排序字符串相等时，两个字符串是字母异位词
 *
 *      二 按计数分类
 *          整体思路和上面的方法是一样的，不过判断的流程换了一下
 *
 *
 */
public class Demo049GroupAnagrams {
    /**
     * 排序数组分类
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // 排序后的字符串作为key，检测异位词
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            // 常规排序
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 按计数分类
     * 评论里提到，当数据量大数据长度很多时，方案二可能要优于方案一（因此我把方案二也写下来了，虽然在测试案例上它比方案一要慢得多26ms > 9ms）
     * @param strs
     * @return
     */
//    public static List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<>();
//        // 设置一个26长度的数组来记录各个字符串含有的各字母的数量
//        int[] count = new int[26];
//        for (String str : strs) {
//            // 默认填充0
//            Arrays.fill(count, 0);
//            // 遍历字母计数
//            for (char c : str.toCharArray()) {
//                count[c - 'a']++;
//            }
//            // 将“#”与计数拼接在一起形成这样的效果：  #2#4#0#0#1  ，即类似于哈希值的唯一标识（这题的关键就是唯一标识）
//            StringBuilder builder = new StringBuilder();
//            for (int i = 0; i < 26; i++) {
//                builder.append("#");
//                builder.append(count[i]);
//            }
//            String s = builder.toString();
//            // 根据上面拼接的字符串确定不同分组
//            if (!map.containsKey(s)) {
//                map.put(s, new ArrayList<>());
//            }
//            map.get(s).add(str);
//        }
//        return new ArrayList<>(map.values());
//    }

    public static void main(String[] args) {
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }
}
