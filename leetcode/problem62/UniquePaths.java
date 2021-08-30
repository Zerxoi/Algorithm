package leetcode.problem62;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 2));
    }

    // 递归超时
    // public int uniquePaths(int m, int n) {
    // return backtrace(m, n, 1, 1);
    // }

    // public int backtrace(int m, int n, int i, int j) {
    // if (m == i && n == j) {
    // return 1;
    // }
    // int sum = 0;
    // if (i < m) {
    // sum += backtrace(m, n, i + 1, j);
    // }
    // if (j < n) {
    // sum += backtrace(m, n, i, j + 1);
    // }
    // return sum;
    // }

    // 动态规划
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
