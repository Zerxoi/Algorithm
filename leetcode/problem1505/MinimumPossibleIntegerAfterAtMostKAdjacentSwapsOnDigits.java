package leetcode.problem1505;

public class MinimumPossibleIntegerAfterAtMostKAdjacentSwapsOnDigits {
    public static void main(String[] args) {
        System.out.println(new MinimumPossibleIntegerAfterAtMostKAdjacentSwapsOnDigits().minInteger("9438957234785635408", 23));
    }

    public String minInteger(String num, int k) {
        int len = num.length();
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = num.charAt(i);
        }

        return backtrace(chars, len, k, num);
    }

    public String backtrace(char[] chars, int len, int m, String cur) {
        if (m == 0) {
            return cur;
        }
        for (int i = 0; i < len - 1; i++) {
            if (chars[i] > chars[i + 1]) {
                swap(chars, i, i + 1);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < len; j++) {
                    sb.append(chars[j]);
                }
                String res = backtrace(chars, len, m - 1, sb.toString());
                for (int j = 0; j < len; j++) {
                    if (res.charAt(j) < cur.charAt(j)) {
                        cur = res;
                    }
                }
                swap(chars, i, i + 1);
            }
        }
        return cur;
    }

    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
