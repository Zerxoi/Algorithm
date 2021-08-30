package leetcode.problem66;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1,9,9})));
    }

    public int[] plusOne(int[] digits) {
        boolean bit = true;
        for (int i = digits.length - 1; i >= 0 && bit; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                bit = true;
            } else {
                digits[i]++;
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
