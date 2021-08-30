package lcof.problem56;

import java.util.Arrays;

public class SolutionI {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SolutionI().singleNumbers(new int[] { 1, 2, 10, 4, 1, 4, 3, 3 })));
    }

    public int[] singleNumbers(int[] nums) {
        int len = nums.length;
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            tmp ^= nums[i];
        }
        int v = 1;
        while ((tmp & v) == 0) {
            v <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < len; i++) {
            if ((nums[i] & v) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[] { a, b };
    }
}
