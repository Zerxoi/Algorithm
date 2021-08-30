package leetcode.problem80;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int pos = 2;
        for (int i = pos; i < nums.length; i++) {
            if (nums[pos - 2] != nums[i]) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
}
