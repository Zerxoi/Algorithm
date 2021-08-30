package leetcode.problem52;

public class NQueensII {
    public int totalNQueens(int n) {
        int[][] table = new int[n][n];
        return backtrace(table, 0);
    }

    public int backtrace(int[][] table, int row) {
        if (row == table.length) {
            return 1;
        }

        int ret = 0;
        for (int j = 0; j < table[row].length; j++) {
            if (table[row][j] < 0) {
                continue;
            }
            table[row][j]++;
            for (int i = 1; row + i < table.length; i++) {
                table[row + i][j]--;
                if (j - i >= 0) {
                    table[row + i][j - i]--;
                }
                if (j + i < table[row].length) {
                    table[row + i][j + i]--;
                }
            }
            ret += backtrace(table, row + 1);
            for (int i = 1; row + i < table.length; i++) {
                table[row + i][j]++;
                if (j - i >= 0) {
                    table[row + i][j - i]++;
                }
                if (j + i < table[row].length) {
                    table[row + i][j + i]++;
                }
            }
            table[row][j]--;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new NQueensII().totalNQueens(4));
    }
}
