package leetcode.problem50;

public class PowXN {
    public static void main(String[] args) {
        new PowXN().myPow(2, 10);
        int x = -2147483648;
        System.out.println(-x);
    }

    public double myPow(double x, int n) {
        boolean neg = false;
        double ret = 1;
        if (n < 0) {
            n = -n;
            neg = true;
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                System.out.println(x);
                ret *= x;
            }
            x *= x;
            n = n >>> 1;
        }
        return neg ? 1 / ret : ret;
    }
}
