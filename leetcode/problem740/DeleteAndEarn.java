package leetcode.problem740;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 和 Problem198 类似
public class DeleteAndEarn {
    public static void main(String[] args) {
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[] { 3, 4, 2 }));
    }

    // 排序+DP
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        // sum 是数值连续元素的累加值序列
        List<Integer> sum = new ArrayList<>();
        sum.add(nums[0]);
        int size = 1;
        for (int i = 1; i < nums.length; i++) {
            int v = nums[i];
            if (nums[i - 1] == v) { // 相同值：元素累加值加元素值
                sum.set(size - 1, sum.get(size - 1) + v);
            } else if (nums[i - 1] + 1 == v) { // 连续：序列中添加元素
                sum.add(v);
                size++;
            } else { // 不连续：计算连续序列的最大值累加至结果中，然后清空序列
                res += rob(sum);
                sum.clear();
                sum.add(nums[i]);
                size = 1;
            }
        }
        // 最后将序列最大值累加至结果
        return res + rob(sum);
    }

    public int rob(List<Integer> sum) {
        int len = sum.size();
        if (len == 1) {
            return sum.get(0);
        }
        // first 是 [0, i-2] 的最大值
        int first = sum.get(0);
        // second 是 [0, i-1] 的最大值
        int second = Math.max(first, sum.get(1));
        for (int i = 2; i < len; i++) {
            int tmp = second;
            // [0, i] 的最大值为 [0, i-1]的最大值 和 [0, i-2]的最大值加第i元素 两者之间最大值
            second = Math.max(tmp, first + sum.get(i));
            first = tmp;
        }
        return second;
    }

    // 回溯法：超时
    // public int deleteAndEarn(int[] nums) {
    // List<Integer> list = new ArrayList<>();
    // for (int i = 0; i < nums.length; i++) {
    // list.add(nums[i]);
    // }
    // return backtrace(list);
    // }

    // public int backtrace(List<Integer> nums) {
    // int res = 0;
    // int len = nums.size();
    // for (int i = 0; i < len; i++) {
    // int tmp = nums.get(i);
    // int earn = tmp;
    // nums.remove(i);
    // List<Integer> deleted = new ArrayList<>();
    // for (int j = 0; j < len - 1; j++) {
    // if (nums.get(j) != earn - 1 && nums.get(j) != earn + 1) {
    // deleted.add(nums.get(j));
    // }
    // }
    // earn += backtrace(deleted);
    // nums.add(tmp);
    // if (earn > res) {
    // res = earn;
    // }
    // }
    // return res;
    // }
}
