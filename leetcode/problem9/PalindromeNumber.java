package leetcode.problem9;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reversed = 0;
        while (reversed < x) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return reversed == x || reversed / 10 == x;
    }
}
