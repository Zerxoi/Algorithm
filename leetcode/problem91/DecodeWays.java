package leetcode.problem91;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("111111111111111111111111111111111111111111111"));
    }

    // public int numDecodings(String s) {
    // return backtrace(s, 0, s.length());
    // }

    // public int backtrace(String s, int pos, int len) {
    //     if (pos > len - 1) {
    //         return 1;
    //     }
    //     if (pos < len && s.charAt(pos) == '0') {
    //         return 0;
    //     }
    //     int res = backtrace(s, pos + 1, len);
    //     if (pos + 2 <= len) {
    //         int tmp = Integer.valueOf(s.substring(pos, pos + 2));
    //         if (0 < tmp && tmp < 27) {
    //             res += backtrace(s, pos + 2, len);
    //         }
    //     }
    //     return res;
    // }

    public int numDecodings(String s) {
        int len = s.length();
        int pre = s.charAt(len - 1) == '0' ? 0 : 1;
        int pre2 = 1;
        for (int i = len - 2; i >= 0; i--) {
            int tmp = 0;
            if (s.charAt(i) != '0') {
                tmp = pre;
                int sub = Integer.valueOf(s.substring(i, i + 2));
                if (10 <= sub && sub <= 26) {
                    tmp += pre2;
                }
            }
            pre2 = pre;
            pre = tmp;
        }
        return pre;
    }
}
