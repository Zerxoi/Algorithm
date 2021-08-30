package leetcode.problem1734;

import java.sql.Time;
import java.util.Arrays;

public class DecodeXoredPermutation {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new DecodeXoredPermutation().decode(new int[] { 7, 5, 6, 11, 14, 15, 11, 6 })));
    }

    public int[] decode(int[] encoded) {
        int len = encoded.length + 1;
        int[] perm = new int[len];
        for (int i = 0; i < len; i++) {
            perm[i] = i + 1;
        }
        return backtrace(perm, 0, encoded);
    }

    public int[] backtrace(int[] perm, int pos, int[] encoded) {
        if (pos == perm.length) {
            for (int i = 0; i < perm.length - 1; i++) {
                if ((perm[i] ^ perm[i + 1]) != encoded[i]) {
                    return null;
                }
            }

            return perm;
        }
        for (int i = pos; i < perm.length; i++) {
            int tmp = perm[i];
            perm[i] = perm[pos];
            perm[pos] = tmp;
            int[] res = backtrace(perm, pos + 1, encoded);
            if (res != null) {
                return res;
            }
            tmp = perm[i];
            perm[i] = perm[pos];
            perm[pos] = tmp;
        }
        return null;
    }
}
