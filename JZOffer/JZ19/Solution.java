package JZOffer.JZ19;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;
        int t = r < c ? (r - 1) / 2 : (c - 1) / 2;
        for (int k = 0; k <= t; k++) {
            for (int j = k; j <= c - 1 - k; j++) {
                list.add(matrix[k][j]);
            }
            for (int i = k + 1; i <= r - 1 - k; i++) {
                list.add(matrix[i][c - 1 - k]);
            }
            if ((r - 1 - k) != k) {
                for (int j = c - 2 - k; j >= k; j--) {
                    list.add(matrix[r - 1 - k][j]);
                }
            }
            if ((c - 1 - k) != k) {
                for (int i = r - 2 - k; i >= k + 1; i--) {
                    list.add(matrix[i][k]);
                }
            }
        }
        return list;
    }
}