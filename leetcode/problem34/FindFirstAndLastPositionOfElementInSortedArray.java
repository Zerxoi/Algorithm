package leetcode.problem34;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (l < 0 || l >= nums.length || nums[l] != target) {
            return new int[] { -1, -1 };
        }
        r = l;
        while (r < nums.length && nums[r] == target) {
            r++;
        }
        return new int[] { l, r - 1 };
    }
}
