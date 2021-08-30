package leetcode.problem14;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
    }

    // 横向扫描
    // public String longestCommonPrefix(String[] strs) {
    // if (strs.length == 0)
    // return "";
    // int len = strs[0].length();
    // for (int i = 1; i < strs.length; i++) {
    // int l = Math.min(len, strs[i].length());
    // int j = 0;
    // while (j < l && strs[0].charAt(j) == strs[i].charAt(j)) {
    // j++;
    // }
    // len = j;
    // }
    // return strs[0].substring(0, len);
    // }

    // 二分法
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int len = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            len = strs[i].length() < len ? strs[i].length() : len;
        }
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (check(strs, i, mid)) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return strs[0].substring(0, i);
    }

    public boolean check(String[] strs, int start, int end) {
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            for (int j = start; j <= end; j++) {
                if (s.charAt(j) != strs[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}