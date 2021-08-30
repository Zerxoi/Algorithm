package leetcode.problem213;

public class HouseRobberII {
    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(new int[] { 1, 3, 1, 100, 3 }));
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len - 1; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        int res = second;
        first = nums[1];
        second = Math.max(nums[1], nums[2]);
        for (int i = 3; i < len; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return res > second ? res : second;
    }
}
