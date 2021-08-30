package leetcode.problem1818;

public class MinimumAbsoluteSumDifference {
    public static void main(String[] args) {
        System.out.println(new MinimumAbsoluteSumDifference().minAbsoluteSumDiff(new int[]{1, 10, 4, 4, 2, 7}, new int[]{9, 3, 5, 1, 7, 4}));
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] nums = new int[len];
        int min = 0;
        for (int i = 0; i < len; i++) {
            nums[i] = Math.abs(nums1[i] - nums2[i]);
            min += nums[i];
        }
        if (min == 0) {
            return min;
        }
        int res = min;
        for (int i = 0; i < len; i++) {
            int dif = 0;
            for (int j = 0; j < len; j++) {
                int k = Math.abs(nums2[j] - nums1[i]);
                dif = Math.min(k - nums[j], dif);
            }
            res = Math.min(min + dif, res);
        }
        return res;
    }
}
