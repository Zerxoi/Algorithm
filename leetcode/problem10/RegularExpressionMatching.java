package leetcode.problem10;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] table = new boolean[slen + 1][plen + 1];

        table[0][0] = true;
        for (int j = 0, n = 0; j < plen; j++) {
            if (p.charAt(j) == '*') {
                n--;
            } else {
                n++;
            }
            if (n == 0) {
                table[0][j + 1] = true;
            }
        }

        for (int j = 1; j <= plen; j++) {
            if (p.charAt(j - 1) == '*') {
                for (int i = 1; i <= slen; i++) {
                    table[i][j] = table[i][j - 2];
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        table[i][j] = table[i][j] || table[i - 1][j] || table[i - 1][j - 1];
                    }
                }
            } else {
                for (int i = 1; i <= slen; i++) {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        table[i][j] = table[i - 1][j - 1];
                    }
                }
            }

        }

        return table[slen][plen];
    }

    public static void main(String[] args) {
        new RegularExpressionMatching().isMatch("aaabb", "a*.b");
    }
}
