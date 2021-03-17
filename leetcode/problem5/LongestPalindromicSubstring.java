package leetcode.problem5;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd"));
    }

    // 暴力解法
    // public String longestPalindrome(String s) {
    // int length = s.length();
    // if (length < 2) {
    // return s;
    // }
    // int l = 0;
    // int r = 0;
    // for (int i = 0; i < length - 1; i++) {
    // for (int j = i + 1; j < length; j++) {
    // if (j - i > r - l && validPalindromic(s, i, j)) {
    // System.out.println("i:" + i + ", j:" + j);
    // l = i;
    // r = j;
    // }
    // }
    // }
    // return s.substring(l, r + 1);
    // }

    // public boolean validPalindromic(String s, int left, int right) {
    // while (left < right) {
    // if (s.charAt(left) == s.charAt(right)) {
    // left++;
    // right--;
    // } else {
    // return false;
    // }
    // }
    // return true;
    // }

    // 动态规划，相较于暴力解法空间换取时间
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if ((j - i < 3 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (j - i > r - l) {
                        l = i;
                        r = j;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return s.substring(l, r + 1);
    }
}
