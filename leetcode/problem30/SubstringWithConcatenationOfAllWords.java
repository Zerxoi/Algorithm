package leetcode.problem30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring("wordgoodgoodgoodbestword",
                new String[] { "word", "good", "best", "word" }));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int num = words.length;
        int word = words[0].length();
        // int length = num * word;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        // for (int i = 0; i < s.length() - length + 1; i++) {
        // Map<String, Integer> tmpMap = new HashMap<>();
        // for (int j = i; j < i + length; j += word) {
        // tmpMap.put(s.substring(j, j + word), tmpMap.getOrDefault(s.substring(j, j +
        // word), 0) + 1);
        // }
        // if (map.equals(tmpMap)) {
        // list.add(i);
        // }
        // }
        for (int i = 0; i < word; i++) {
            Map<String, Integer> tmpMap = new HashMap<>();
            int l = i;
            int count = 0;
            for (int r = i; r < s.length() - word + 1; r += word) {
                String sub = s.substring(r, r + word);
                tmpMap.put(sub, tmpMap.getOrDefault(sub, 0) + 1);
                count++;
                while (tmpMap.getOrDefault(sub, 0) > map.getOrDefault(sub, 0)) {
                    tmpMap.put(s.substring(l, l + word), tmpMap.get(s.substring(l, l + word)) - 1);
                    l += word;
                    count--;
                }
                if (count == num) {
                    list.add(l);
                }
            }
        }
        return list;
    }

    // public List<Integer> findSubstring(String s, String[] words) {
    // List<Integer> list = new ArrayList<>();
    // Arrays.sort(words);
    // boolean[] vis = new boolean[words.length];
    // backtrace(s, words, vis, 0, new StringBuilder(), list);
    // return list;
    // }

    // public void backtrace(String s, String[] words, boolean[] vis, int pos,
    // StringBuilder sb, List<Integer> list) {
    // if (pos == words.length) {
    // int idx = s.indexOf(sb.toString());
    // if (idx != -1) {
    // list.add(idx);
    // }
    // return;
    // }

    // for (int i = 0; i < vis.length; i++) {
    // if (vis[i] || (i > 0 && words[i - 1] == words[i] && !vis[i - 1])) {
    // continue;
    // }
    // vis[i] = true;
    // int len = sb.length();
    // sb.append(words[i]);
    // backtrace(s, words, vis, pos + 1, sb, list);
    // sb.delete(len, sb.length());
    // vis[i] = false;
    // }
    // }
}
