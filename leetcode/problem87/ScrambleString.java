package leetcode.problem87;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
    public static void main(String[] args) {
        System.out.println(new ScrambleString().isScramble("great", "rgeat"));
    }

    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        int[][][] dp = new int[len][len][len];
        return dfs(s1, s2, 0, 0, len, dp);

    }

    public boolean dfs(String s1, String s2, int i1, int i2, int length, int[][][] dp) {
        if (dp[i1][i2][length - 1] != 0) {
            return dp[i1][i2][length - 1] == 1;
        }
        if (s1.substring(i1, i1 + length).equals(s2.substring(i2, i2 + length))) {
            dp[i1][i2][length - 1] = 1;
            return true;
        }
        if (!checkIfSimilar(s1, s2, i1, i2, length)) {
            dp[i1][i2][length - 1] = -1;
            return false;
        }
        for (int i = 1; i < length; i++) {
            if (dfs(s1, s2, i1, i2, i, dp) && dfs(s1, s2, i1 + i, i2 + i, length - i, dp)) {
                dp[i1][i2][length - 1] = 1;
                return true;
            }
            if (dfs(s1, s2, i1, i2 + length - i, i, dp) && dfs(s1, s2, i1 + i, i2, length - i, dp)) {
                dp[i1][i2][length - 1] = 1;
                return true;
            }
        }
        dp[i1][i2][length - 1] = -1;
        return false;
    }

    public boolean checkIfSimilar(String s1, String s2, int i1, int i2, int length) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = s1.charAt(i1 + i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            char c = s2.charAt(i2 + i);
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (Integer v : map.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }

}