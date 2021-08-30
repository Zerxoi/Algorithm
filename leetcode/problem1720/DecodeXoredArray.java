package leetcode.problem1720;

import java.util.Arrays;

public class DecodeXoredArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DecodeXoredArray().decode(new int[] { 1, 2, 3 }, 1)));
    }

    public int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] arr = new int[len + 1];
        arr[0] = first;
        for (int i = 0; i < len; i++) {
            arr[i + 1] = arr[i] ^ encoded[i];
        }
        return arr;
    }
}
