package ot;

// 最大左匹配字符串
public class AliSolution0507_2 {
    // 动态规划
    // public static void main(String[] args) {
    // String s1 = "134mmabemcdefgm";
    // String s2 = "cdefgm";
    // int len = s1.length();
    // int[] dp = new int[len + 1];
    // int max = 0;
    // for (int i = 0; i < len; i++) {
    // if (s2.charAt(dp[i]) == s1.charAt(i)) {
    // dp[i + 1] = dp[i] + 1;
    // if (dp[i + 1] == s2.length()) {
    // max = dp[i + 1];
    // break;
    // }
    // if (dp[i + 1] > max) {
    // max = dp[i + 1];
    // }
    // }
    // }
    // System.out.println(s2.substring(0, max));
    // }

    // 动规优化
    public static void main(String[] args) {
        String s1 = "134mmabemcdefgm";
        String s2 = "mcdf";
        int len = s1.length();
        int max = 0;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (s2.charAt(j) == s1.charAt(i)) {
                j++;
                if (j == s2.length()) {
                    max = j;
                    break;
                }
                if (j > max) {
                    max = j;
                }
            } else {
                j = 0;
            }
        }
        System.out.println(s2.substring(0, max));
    }

}
