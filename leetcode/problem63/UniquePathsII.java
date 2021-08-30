package leetcode.problem63;

public class UniquePathsII {
    public static void main(String[] args) {
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][] { { 0, 1 }, { 0, 0 } }));
    }

    // 动态规划
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        if (obstacleGrid[n - 1][m - 1] == 1) {
            return 0;
        }
        dp[n - 1][m - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] += (i + 1 < n ? dp[i + 1][j] : 0) + (j + 1 < m ? dp[i][j + 1] : 0);
            }
        }
        return dp[0][0];
    }
}
