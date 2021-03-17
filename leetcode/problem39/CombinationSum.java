package leetcode.problem39;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[] { 2, 3, 5 }, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, candidates, 0, target, new ArrayList<>());
        return lists;
    }

    public void backtrack(List<List<Integer>> lists, int[] candidates, int index, int target, List<Integer> list) {
        if (target == 0) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        if (index == candidates.length || target < 0) {
            return;
        }
        backtrack(lists, candidates, index + 1, target, list);
        if (target - candidates[index] >= 0) {
            list.add(candidates[index]);
            backtrack(lists, candidates, index, target - candidates[index], list);
            list.remove(list.size() - 1);
        }
    }
}
