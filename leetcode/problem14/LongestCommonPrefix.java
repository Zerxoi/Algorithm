package leetcode.problem14;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int len = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int l = Math.min(len, strs[i].length());
            int j = 0;
            while (j < l && strs[0].charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            len = j;
        }
        return strs[0].substring(0, len);
    }

}