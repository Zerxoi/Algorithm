package leetcode.problem32;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("()(())"));
    }

    // 动态规划
    // 时间复杂度：O(n) 空间复杂度：O(n)
    // public int longestValidParentheses(String s) {
    // int max = 0;
    // int len = s.length();
    // int[] dp = new int[len + 1];
    // for (int i = 0; i < len; i++) {
    // char c = s.charAt(i);
    // if (c == ')') {
    // if (i - dp[i] - 1 >= 0 && s.charAt(i - dp[i] - 1) == '(') {
    // dp[i + 1] = dp[i - dp[i] - 1] + dp[i] + 2;
    // max = dp[i + 1] > max ? dp[i + 1] : max;
    // }
    // }
    // }
    // return max;
    // }

    // 暴力解法
    // 时间复杂度：O(n^2) 空间复杂度：O(1)
    // public int longestValidParentheses(String s) {
    // int max = 0;
    // for (int i = 0; i < s.length(); i++) {
    // char c = s.charAt(i);
    // if (c == ')') {
    // continue;
    // }
    // int count = 0;
    // for (int j = i; j < s.length(); j++) {
    // c = s.charAt(j);
    // if (c == '(') {
    // count++;
    // } else {
    // count--;
    // if (count == 0) {
    // max = j - i + 1 > max ? j - i + 1 : max;
    // } else if (count < 0) {
    // break;
    // }
    // }
    // }
    // }
    // return max;
    // }

    // 正反遍历
    // 时间复杂度：O(n) 空间复杂度：O(1)
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = right + left > max ? right + left : max;
            }
            if (right > left) {
                right = 0;
                left = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                max = left + right > max ? left + right : max;
            }
            if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return max;
    }
}
