public class Test {
    // 找出数组中沿上下左右方向的递增路径的最大长度
    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // int m = input.nextInt();
        // int n = input.nextInt();
        // int[][] nums = new int[m][n];
        int m = 3;
        int n = 3;
        int[][] nums = { { 1, 3, 3 }, { 2, 4, 9 }, { 8, 9, 2 } };
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // nums[i][j] = input.nextInt();
        // }
        // }
        int[][] dp = new int[m][n];
        int k = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] == k) {
                        if ((i - 1 >= 0 && nums[i - 1][j] < nums[i][j] && dp[i - 1][j] >= k)
                                || (i + 1 <= m - 1 && nums[i + 1][j] < nums[i][j] && dp[i + 1][j] >= k)
                                || (j - 1 >= 0 && nums[i][j - 1] < nums[i][j] && dp[i][j - 1] >= k)
                                || (j + 1 <= n - 1 && nums[i][j + 1] < nums[i][j] && dp[i][j + 1] >= k)) {
                            dp[i][j]++;
                            flag = true;
                        }
                    }
                }
            }
            k++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(k);
        // input.close();
    }
}
