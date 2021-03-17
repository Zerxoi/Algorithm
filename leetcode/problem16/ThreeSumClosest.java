package leetcode.problem16;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[] { 1, 1, 1, 1 }, 4));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = nums[0] + nums[1] + nums[2];
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    j++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    if (target - sum < Math.abs(target - ret)) {
                        ret = sum;
                    }
                    j++;
                } else {
                    if (sum - target < Math.abs(target - ret)) {
                        ret = sum;
                    }
                    k--;
                }
            }
        }
        return ret;
    }
}