package leetcode.problem45;

public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(new JumpGameII().jump(new int[] { 3, 2, 1 }));
    }

    // 动态规划
    // 时间复杂度 O(N) 空间复杂度 O(N)
    // public int jump(int[] nums) {
    // int[] dp = new int[nums.length];
    // dp[nums.length - 1] = 0; // 末尾位置位 0
    // // dp[i] 表示放从 nums i 位置跳跃到最终位置的最少跳跃
    // for (int i = nums.length - 2; i >= 0; i--) { // 从后向前找到计算跳跃到最终位置最小跳
    // int min = dp[i + 1];
    // for (int j = i + 2; j <= i + nums[i] && j < nums.length; j++) { //
    // 找出i元素跳跃距离内最小跳跃
    // min = min < dp[j] ? min : dp[j];
    // }
    // dp[i] = min + 1; // i位置的最小跳跃赋值
    // }
    // return dp[0];
    // }

    // 贪心算法
    // 时间复杂度 O(N) 空间复杂度O(1)
    public int jump(int[] nums) {
        int len = nums.length;
        int step = 0;
        int j = 0;
        int longest = 0; // 从上一个j到i之间能到达的最远距离
        for (int i = 0; i < len - 1; i++) { // [i,j] 对应第 step 跳的可选范围
            // 至于为什么是 len-1 是因为，如果i能到len-1，表明第step跳可以跳到最后一个元素，step也不用增加，直接退出就可以
            longest = Math.max(longest, i + nums[i]); // 更新[i,j] 之间最远距离
            if (i == j) {
                j = longest;
                step++;
            }
        }
        return step;
    }
}
