package leetcode.problem39;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrace(candidates, 0, target, list, lists);
        return lists;
    }

    // 循环内截止条件

    // 当前值
    // public void backtrace(int[] candidates, int pos, int cur, int target,
    // List<Integer> list,
    // List<List<Integer>> lists) {
    // for (int i = pos; i < candidates.length; i++) {
    // if (cur > target) {
    // return;
    // } else if (cur == target) { // 当前值和目标值相等
    // lists.add(new ArrayList<>(list));
    // return;
    // } else {
    // if (cur + candidates[i] == target) { // 当最后一个参与者添加后，如果通过回溯无法进入 for
    // 循环，因此要在这里另外判断
    // list.add(candidates[i]);
    // lists.add(new ArrayList<>(list));
    // list.remove(list.size() - 1);
    // } else if (cur + candidates[i] < target) {
    // list.add(candidates[i]);
    // backtrace(candidates, i, cur + candidates[i], target, list, lists);
    // list.remove(list.size() - 1);
    // }
    // }
    // }
    // }

    // 目标值
    // public void backtrace(int[] candidates, int pos, int target, List<Integer>
    // list, List<List<Integer>> lists) {
    // for (int i = pos; i < candidates.length; i++) {
    // if (target < 0) {
    // return;
    // } else if (target == 0) { // -
    // lists.add(new ArrayList<>(list));
    // return;
    // } else {
    // if (candidates[i] == target) {
    // list.add(candidates[i]);
    // lists.add(new ArrayList<>(list));
    // list.remove(list.size() - 1);
    // } else if (candidates[i] < target) {
    // list.add(candidates[i]);
    // backtrace(candidates, i, target - candidates[i], list, lists);
    // list.remove(list.size() - 1);
    // }
    // }
    // }
    // }

    // 条件外截止条件
    public void backtrace(int[] candidates, int pos, int target, List<Integer> list, List<List<Integer>> lists) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        if (pos >= candidates.length || target < 0) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) { // 索引增加
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                backtrace(candidates, i, target - candidates[i], list, lists); // 目标值减小
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().combinationSum(new int[] { 2, 3, 6, 7 }, 7));
    }
}
