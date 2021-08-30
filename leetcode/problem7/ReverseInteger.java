package leetcode.problem7;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-2147483412));
    }

    // public int reverse(int x) {
    // int rev = 0;
    // while (x != 0) {
    // int pop = x % 10;
    // if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop >
    // 7))
    // return 0;
    // if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop <
    // -8))
    // return 0;
    // rev = rev * 10 + x % 10;
    // x /= 10;
    // }
    // return rev;
    // }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int mod = x % 10;
            if (res > 214748364 || res == 214748364 && mod > 7 || res < -214748364 || res == -214748364 && mod < -8) {
                return 0;
            }
            res = res * 10 + mod;
            x /= 10;
        }
        return res;
    }
}
