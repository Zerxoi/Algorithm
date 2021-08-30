package leetcode.problem36;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] visited = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (visited[board[i][j] - '1']) {
                        return false;
                    } else {
                        visited[board[i][j] - '1'] = true;
                    }
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            boolean[] visited = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (visited[board[i][j] - '1']) {
                        return false;
                    } else {
                        visited[board[i][j] - '1'] = true;
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            int x = i / 3 * 3;
            int y = (i % 3) * 3;
            boolean[] visited = new boolean[9];
            for (int m = x; m < x + 3; m++) {
                for (int n = y; n < y + 3; n++) {
                    if (board[m][n] != '.') {
                        if (visited[board[m][n] - '1']) {
                            return false;
                        } else {
                            visited[board[m][n] - '1'] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
