package leetcode.problem90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(nums, 0, new ArrayList<>(), lists);
        return lists;
    }

    public void backtrace(int[] nums, int pos, List<Integer> list, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backtrace(nums, i + 1, list, lists);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SubsetsII().subsetsWithDup(new int[] { 1, 2, 2 }));
    }
}
