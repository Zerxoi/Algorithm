package leetcode.problem44;

public class WildcardMatching {
    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("abceb", "a*b"));
    }

    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();

        boolean[][] table = new boolean[m + 1][n + 1];
        table[0][0] = true;
        for (int i = 0; i < m && p.charAt(i) == '*'; i++) {
            table[i + 1][0] = true;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p.charAt(i) == '*') {
                    table[i + 1][j + 1] = table[i + 1][j] || table[i][j + 1];
                } else if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) {
                    table[i + 1][j + 1] = table[i][j];
                }
            }
        }

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }

        return table[m][n];
    }

}
