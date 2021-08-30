package leetcode.problem47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(nums, 0, vis, new ArrayList<>(), lists);
        return lists;
    }

    public void backtrace(int[] nums, int pos, boolean[] vis, List<Integer> list, List<List<Integer>> lists) {
        if (pos == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            vis[i] = true;
            backtrace(nums, pos + 1, vis, list, lists);
            vis[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[] { 1, 1, 2, 2 }));
    }
}

// 一开始的想法，但是存在错误
// class Solution {
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         List<List<Integer>> lists = new ArrayList<>();
//         Arrays.sort(nums);
//         backtrace(nums, 0, lists);
//         return lists;
//     }

//     public void backtrace(int[] nums, int pos, List<List<Integer>> lists) {
//         if (pos == nums.length) {
//             List<Integer> list = new ArrayList<>();
//             for (int i = 0; i < nums.length; i++) {
//                 list.add(nums[i]);
//             }
//             lists.add(list);
//         }
//         for (int i = pos; i < nums.length; i++) {
//             if (i > pos && (nums[i] == nums[pos] || nums[i] == nums[i - 1])) // 错误在这里，以为如果前面的元素和比较后面的元素替换，该条件不成立
//                 continue;
//             swap(nums, i, pos);
//             backtrace(nums, pos + 1, lists);
//             swap(nums, i, pos);
//         }
//     }

//     public void swap(int[] nums, int i, int j) {
//         int tmp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = tmp;
//     }
// }