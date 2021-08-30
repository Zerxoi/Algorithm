package leetcode.problem31;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 9, 9, 9 };
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int pos = nums.length - 1;
        while (pos > 0 && nums[pos - 1] >= nums[pos]) {
            pos--;
        }
        for (int i = pos, j = nums.length - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        if (pos == 0) {
            return;
        }
        int i = pos;
        while (i < nums.length && nums[i] <= nums[pos - 1]) {
            i++;
        }
        int tmp = nums[i];
        nums[i] = nums[pos - 1];
        nums[pos - 1] = tmp;
    }
}
