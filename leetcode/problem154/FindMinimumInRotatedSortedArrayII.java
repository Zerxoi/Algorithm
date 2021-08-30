package leetcode.problem154;

public class FindMinimumInRotatedSortedArrayII {
    public static void main(String[] args) {
        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[] { 2, 2, 2, 0, 1 }));
    }

    // 这样判断左右边太麻烦
    // public int findMin(int[] nums) {
    // int i = 0;
    // int j = nums.length - 1;
    // while (i < j) {
    // int mid = i + ((j - i) >> 1);
    // if (nums[i] < nums[mid]) {
    // if (nums[mid] <= nums[j]) {
    // j = mid - 1;
    // } else {
    // i = mid + 1;
    // }
    // } else if (nums[i] > nums[mid]) {
    // j = mid;
    // } else {
    // if (nums[mid] < nums[j]) {
    // j = mid;
    // } else if (nums[mid] > nums[j]) {
    // i = mid + 1;
    // } else {
    // i++;
    // }
    // }
    // }
    // return nums[i];
    // }

    // 先用 mid 和 j 先比较更好
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] > nums[j]) { // mid 大于 j 说明最小值一定在右边且 mid 不能是最小值
                i = mid + 1;
            } else if (nums[mid] < nums[j]) { // mid 小于 j 说明最小值一定在左边，但是 mid 有可能是最小值所以不用mid-1
                j = mid;
            } else { // mid 和 j 相同又可分为两种情况
                if (nums[i] == nums[mid]) { // 如果 i，mid 和 j 都相同，无法判断是哪一侧，通过i++减小范围
                    i++;
                } else { // i 小于 mid 或者 i 大于 mid 最小值都是在左侧，但是mid有可能是最小值，所以不用mid-1
                    j = mid;
                }
            }
        }
        return nums[i];
    }
}
