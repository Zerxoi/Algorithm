package lcof.problem11;

public class Solution {
    public int NumberOf1(int n) {
        int i = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                i++;
            }
            // >>> 符号右移 高位补0
            // >>  符号右移 高位补符号位
            n = n >>> 1;
        }
        return i;
    }

    public int NumberOf1Ultra(int n) {
        int i = 0;
        while (n != 0) {
            n = n & (n - 1);
            i++;
        }
        return i;
    }
}