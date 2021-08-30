package lcof.problem12;

public class NonRecSolution {
    public double Power(double base, int exponent) {
        if (exponent < 0) {
            exponent = -exponent;
            base = 1 / base;
        }
        double x = base;
        double res = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                res *= x;
            }
            x *= x;
            exponent = exponent >> 1;
        }
        return res;
    }
}
