package leetcode.problem263;

public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(new UglyNumber().isUgly(7));
    }

    public boolean isUgly(int n) {
        if (n <= 0) { // 小于等于零直接返回false
            return false;
        }
        while (n > 1) { // n > 1 判断能不能被 2，3，5 整除
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else {
                return false;
            }
        }
        return true; // 如果 n == 1 返回true
    }
}
