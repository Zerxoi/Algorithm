package leetcode.problem46;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrace(nums, 0, lists);
        return lists;
    }

    public void backtrace(int[] nums, int pos, List<List<Integer>> lists) {
        if (pos == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int k = 0; k < nums.length; k++) {
                list.add(nums[k]);
            }
            lists.add(list);
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            swap(nums, pos, i);
            backtrace(nums, pos + 1, lists);
            swap(nums, pos, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[] { 1, 2, 3 }));
    }
}
