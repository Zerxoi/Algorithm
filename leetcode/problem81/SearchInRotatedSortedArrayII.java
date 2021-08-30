package leetcode.problem81;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[i] < nums[mid]) {
                if (nums[i] <= target && target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else if (nums[i] > nums[mid]) {
                if (nums[mid] < target && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else { // 如果 nums[i] == nums[mid] 但是 nums[mid] != target 所以 nums[i] 一定不等于 target 所以 i++
                i++;
            }
        }
        return false;
    }
}
