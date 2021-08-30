package leetcode.problem49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out
                .println(new GroupAnagrams().groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }

    // public List<List<String>> groupAnagrams(String[] strs) {
    // int len = strs.length;
    // Map<Map<Character, Integer>, List<String>> maps = new HashMap<>(); // 使用 map
    // 对象作为异构词的标识符
    // for (int i = 0; i < len; i++) {
    // String s = strs[i];

    // Map<Character, Integer> map = new HashMap<>();
    // for (int j = 0; j < s.length(); j++) { // 每一个字符串元素创建一个 map 对象
    // map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
    // }

    // List<String> list = maps.getOrDefault(map, new ArrayList<>()); //
    // 如果存在该异构返回list，否则新建一个新的ArrayList
    // list.add(s);
    // maps.put(map, list); // 将异构词添加到 maps中
    // }
    // return new ArrayList<>(maps.values());
    // }

    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        Map<String, List<String>> map = new HashMap<>(); // 使用排序好的字符串作为异构词标识
        for (int i = 0; i < len; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String hash = new String(chars);
            List<String> list = map.getOrDefault(hash, new ArrayList<>());
            list.add(strs[i]);
            map.put(hash, list);
        }
        return new ArrayList<>(map.values());
    }
}
