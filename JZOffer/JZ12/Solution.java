package JZOffer.JZ12;

public class Solution {
    public double Power(double base, int exponent) {
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        return rec(base, exponent);
    }

    public double rec(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        double tmp = rec(base, exponent / 2);
        if ((exponent & 1) == 1) {
            return tmp * tmp * base;
        } else {
            return tmp * tmp;
        }
    }

}