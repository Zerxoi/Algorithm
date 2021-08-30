package leetcode.problem153;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(new int[] { 3, 4, 5, 1, 2 }));
    }

    // public int findMin(int[] nums) {
    // int i = 0;
    // int j = nums.length - 1;
    // while (i <= j) { // 最小值一定在 [i,j] 之间
    // int mid = i + ((j - i) >> 1);
    // if (j == i) { // 如果 i == j，即只有一个元素了，最小值一定是该元素
    // return nums[i];
    // }
    // if (nums[i] < nums[mid] && nums[mid] <= nums[j]) {
    // j = mid - 1; // nums[mid] 介于nums[i] 和 nums[j] 之间，最小值一定在左侧，又因为 nums[mid] 大于
    // nums[i] 所以 nums[mid] 一定不是最小值
    // } else if (nums[i] <= nums[mid] && nums[mid] > nums[j]) {
    // i = mid + 1; // nums[mid] 大于两侧 nums[i] 和 nums[j] 的值，最小值一定在右侧，因为 nums[mid] 大于
    // nums[j] 所以 nums[mid] 一定在不是最小值
    // } else if (nums[i] >= nums[mid] && nums[mid] <= nums[j]) {
    // j = mid; // nums[mid] 小于等于两侧 nums[i] 和 nums[j] 的值，最小值一定在左侧，但是不能判断 nums[mid]
    // 是否为最小值，所以 j = mid
    // }
    // }
    // return nums[i];
    // }

    // 先 i 跟 mid 比，再 mid 跟 j 比，麻烦!
    // public int findMin(int[] nums) {
    // int i = 0;
    // int j = nums.length - 1;
    // while (i < j) { // 最小值一定在 [i,j] 之间
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
    // if (nums[mid] <= nums[j]) {
    // j = mid;
    // } else {
    // i = mid + 1;
    // }
    // }
    // }
    // return nums[i];
    // }

    // mid 和 j 比较，很容易判断是选左边还是右边
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) { // 最小值一定在 [i,j] 之间
            int mid = i + ((j - i) >> 1);
            if (nums[mid] < nums[j]) {
                j = mid; // 因为 mid 可能是最小值，所以不等于 mid-1
            } else { // else 语句块实际上是 nums[mid] > nums[j],因为如果i<j等情况不可能有mid==j
                i = mid + 1;
            }
        }
        return nums[i];
    }
}
