package leetcode.problem37;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        new SudokuSolver().solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        backtrace(board, 0);
    }

    public boolean backtrace(char[][] board, int pos) {
        while (pos < 81 && board[pos / 9][pos % 9] != '.') {
            pos++;
        }
        if (pos == 81) {
            return true;
        }

        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[pos / 9][i] != '.') {
                used[board[pos / 9][i] - '1'] = true;
            }
            if (board[i][pos % 9] != '.') {
                used[board[i][pos % 9] - '1'] = true;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[pos / 27 * 3 + i][pos % 9 / 3 * 3 + j] != '.') {
                    used[board[pos / 27 * 3 + i][pos % 9 / 3 * 3 + j] - '1'] = true;
                }
            }
        }

        for (char i = '1'; i <= '9'; i++) {
            if (used[i - '1'] == false) {
                board[pos / 9][pos % 9] = i;
                if (backtrace(board, pos + 1)) {
                    return true;
                }
                board[pos / 9][pos % 9] = '.';
            }
        }

        return false;
    }
}
