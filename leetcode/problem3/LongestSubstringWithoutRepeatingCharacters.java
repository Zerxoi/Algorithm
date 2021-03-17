package leetcode.problem3;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int j = -1;
        int ans = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            while (j + 1 < length && !set.contains(s.charAt(j + 1))) {
                set.add(s.charAt(j + 1));
                j++;
            }
            ans = Math.max(ans, j - i + 1);
            set.remove(s.charAt(i));
        }
        return ans;
    }
}