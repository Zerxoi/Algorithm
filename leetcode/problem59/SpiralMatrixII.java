package leetcode.problem59;

public class SpiralMatrixII {
    public static void main(String[] args) {
        new SpiralMatrixII().generateMatrix(4);
    }

    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int m = (n + 1) / 2;
        int count = 1;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n - i; j++) {
                nums[i][j] = count++;
            }
            for (int j = i + 1; j < n - i; j++) {
                nums[j][n - 1 - i] = count++;
            }
            if (i < n - i - 1) {
                for (int j = n - i - 2; j >= i; j--) {
                    nums[n - i - 1][j] = count++;
                }
                for (int j = n - i - 2; j > i; j--) {
                    nums[j][i] = count++;
                }
            }
        }
        return nums;
    }
}
