package leetcode.problem29;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers obj = new DivideTwoIntegers();

        System.out.println(obj.divide(Integer.MIN_VALUE, -2));

    }

    public int divide(int dividend, int divisor) {
        if (divisor == 1)
            return dividend;
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (divisor == -1 && dividend > Integer.MIN_VALUE) {
            return -1 * dividend;
        }

        int flag = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            flag = -1;
        }
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;

        int res = div(dividend, divisor);
        return flag * res;
    }

    public int div(int dividend, int divisor) {
        int ret = 0;
        while (dividend <= divisor) {
            int i = 1;
            int tmp = divisor;
            while (dividend - tmp <= tmp) {
                tmp = tmp << 1;
                i = i << 1;
            }
            dividend -= tmp;
            ret += i;
        }
        return ret;
    }
}
