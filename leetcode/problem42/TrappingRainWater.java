package leetcode.problem42;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

    // 动态规划
    // public int trap(int[] height) {
    // int len = height.length;
    // if (len == 0) {
    // return 0;
    // }
    // int[] dp = new int[len]; // dp[i] 记录数组元素0到数组元素i能接多少雨水
    // for (int i = 2; i < len; i++) {
    // dp[i] += dp[i - 1];
    // if (height[i - 1] < height[i]) { // 计算高度i多出的积水
    // int low = height[i - 1]; // 低洼高度
    // for (int j = i - 2; j >= 0; j--) {
    // if (height[j] > low) {
    // dp[i] += (i - j - 1) * (Math.min(height[j], height[i]) - low); //
    // 高度i到高度j之间大于低洼高度的积水
    // low = height[j]; // 低洼高度上涨
    // }
    // if (height[j] >= height[i]) { // j高度 超过 i高度截至
    // break;
    // }
    // }
    // }
    // }
    // return dp[len - 1];
    // }

    // 双指针法
    // public int trap(int[] height) {
    // int sum = 0;
    // int i = 0;
    // int j = height.length - 1;
    // int leftMax = 0;
    // int rightMax = 0;
    // while (i < j) {
    // leftMax = leftMax > height[i] ? leftMax : height[i];
    // rightMax = rightMax > height[j] ? rightMax : height[j];
    // if (height[i] < height[j]) {
    // sum += leftMax - height[i++];
    // } else {
    // sum += rightMax - height[j--];
    // }
    // }
    // return sum;
    // }

    // 双指针（自己重写一遍）
    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int low = 0;
        int sum = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                if (height[i] < low) {
                    sum += low - height[i];
                } else {
                    low = height[i];
                }
                i++;
            } else {
                if (height[j] < low) {
                    sum += low - height[j];
                } else {
                    low = height[j];
                }
                j--;
            }
        }
        return sum;
    }
}