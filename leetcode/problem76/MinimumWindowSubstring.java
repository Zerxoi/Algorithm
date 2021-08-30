package leetcode.problem76;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("a", "aa"));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int reti = 0;
        int retj = -1;
        int min = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 0; j < s.length(); j++) { // 扩张 j
            Integer count = need.get(s.charAt(j));
            if (count != null) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if (check(map, need)) {
                    while (i < s.length()) { // 收缩 i
                        if (need.get(s.charAt(i)) == null) { // 不是需要的字符
                            i++;
                        } else if (map.get(s.charAt(i)) > need.get(s.charAt(i))) {
                            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                            i++;
                        } else {
                            break;
                        }
                    }
                    if (min > j - i + 1) {
                        min = j - i + 1;
                        reti = i;
                        retj = j;
                    }
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    i++;
                }
            }
        }
        return s.substring(reti, retj + 1);
    }

    public boolean check(Map<Character, Integer> map, Map<Character, Integer> need) {
        Set<Character> keys = need.keySet();
        for (Character character : keys) {
            if (map.get(character) == null || map.get(character) < need.get(character)) {
                return false;
            }
        }
        return true;
    }
}
