package leetcode.problem48;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        new RotateImage().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) { // 1维矩阵旋转0次，2，3维矩阵旋转1次，4，5维矩阵旋转2次，所以旋转次数为n/2
            for (int j = 0; j < n - 2 * i - 1; j++) { // 旋转元素数位 n-2*i-1 个
                int tmp = matrix[i + j][n - 1 - i]; // 交换4个元素的位置
                matrix[i + j][n - 1 - i] = matrix[i][i + j];
                matrix[i][i + j] = matrix[n - 1 - i - j][i];
                matrix[n - 1 - i - j][i] = matrix[n - 1 - i][n - 1 - i - j];
                matrix[n - 1 - i][n - 1 - i - j] = tmp;
            }
        }
    }
}
