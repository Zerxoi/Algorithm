package leetcode.problem137;

public class SingleNumberII {
    public static void main(String[] args) {
        System.out.println(new SingleNumberII().singleNumber(new int[] { 0, 1, 0, 1, 0, 1, 99 }));
    }

    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            int num = nums[i];
            while (num != 0) {
                if ((num & 1) == 1) {
                    bits[j]++;
                }
                j++;
                num >>>= 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            if (bits[i] % 3 != 0) {
                res++;
            }
        }
        return res;
    }

}