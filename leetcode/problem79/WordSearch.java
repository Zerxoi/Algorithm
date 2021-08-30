package leetcode.problem79;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(new WordSearch().exist(board, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] table = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) != board[i][j]) {
                    continue;
                }
                table[i][j] = true;
                if (backtrace(board, word, 1, table, i, j)) {
                    return true;
                }
                table[i][j] = false;
            }
        }
        return false;
    }

    public boolean backtrace(char[][] board, String word, int pos, boolean[][] table, int i, int j) {
        if (pos == word.length()) {
            return true;
        }
        char cur = word.charAt(pos);
        if (i - 1 >= 0 && board[i - 1][j] == cur && !table[i - 1][j]) {
            table[i - 1][j] = true;
            if (backtrace(board, word, pos + 1, table, i - 1, j)) {
                return true;
            }
            table[i - 1][j] = false;
        }
        if (i + 1 < board.length && board[i + 1][j] == cur && !table[i + 1][j]) {
            table[i + 1][j] = true;
            if (backtrace(board, word, pos + 1, table, i + 1, j)) {
                return true;
            }
            table[i + 1][j] = false;
        }
        if (j - 1 >= 0 && board[i][j - 1] == cur && !table[i][j - 1]) {
            table[i][j - 1] = true;
            if (backtrace(board, word, pos + 1, table, i, j - 1)) {
                return true;
            }
            table[i][j - 1] = false;
        }
        if (j + 1 < board[i].length && board[i][j + 1] == cur && !table[i][j + 1]) {
            table[i][j + 1] = true;
            if (backtrace(board, word, pos + 1, table, i, j + 1)) {
                return true;
            }
            table[i][j + 1] = false;
        }
        return false;
    }
}
