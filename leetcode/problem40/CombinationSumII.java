package leetcode.problem40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<java.util.List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(candidates, 0, target, new ArrayList<>(), lists);
        return lists;
    }

    public void backtrace(int[] candidates, int pos, int target, List<Integer> list, List<List<Integer>> lists) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || pos >= candidates.length) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            while (i > pos && candidates[i] == candidates[i - 1]) {
                i++;
            }
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                backtrace(candidates, i + 1, target - candidates[i], list, lists);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumII().combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
    }
}
