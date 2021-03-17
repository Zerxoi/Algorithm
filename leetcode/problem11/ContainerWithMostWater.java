package leetcode.problem11;

public class ContainerWithMostWater {
    // 暴力法
    // public int maxArea(int[] height) {
    // int length = height.length;
    // int max = 0;
    // for (int i = 0; i < length; i++) {
    // for (int j = i + 1; j < length; j++) {
    // int tmp = (j - i) * Math.min(height[i], height[j]);
    // if (tmp > max) {
    // max = tmp;
    // }
    // }
    // }
    // return max;
    // }
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            max = height[i] < height[j] ? Math.max(max, (j - i) * height[i++]) : Math.max(max, (j - i) * height[j--]);
        }
        return max;
    }

}
