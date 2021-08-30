package leetcode.problem51;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        int[][] table = new int[n][n];
        backtrace(table, 0, lists);
        return lists;
    }

    public void backtrace(int[][] table, int row, List<List<String>> lists) {
        if (row == table.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < table.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < table[i].length; j++) {
                    if (table[i][j] > 0) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            lists.add(list);
            return;
        }
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
            backtrace(table, row + 1, lists);
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
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
}
