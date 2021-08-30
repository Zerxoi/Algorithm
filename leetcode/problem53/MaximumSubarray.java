package leetcode.problem53;

public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < len; i++) { // sum 起初计算从 0 到 i 的累加值
            sum += nums[i];
            max = sum > max ? sum : max; // max 会记录出现过的最大值
            if (sum < 0) { // 如果 sum < 0 继续累加值对后续的最大值有影响，所以sum清零
                sum = 0;
            }
        }
        return max;
    }
}
