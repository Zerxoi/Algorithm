package leetcode.problem78;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrace(nums, 0, new ArrayList<>(), lists);
        return lists;
    }

    public void backtrace(int[] nums, int pos, List<Integer> list, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace(nums, i + 1, list, lists);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[] { 1, 2, 3 }));
    }
}
