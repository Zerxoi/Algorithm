package leetcode.problem56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] nums = new MergeIntervals().merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } });
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i][0] + "\t" + nums[i][1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        // 先对 intervals 数组按照 intervals[i][0] 元素进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n;) {
            // 先确定合并区间的左右
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 再从 i+1 开始，看能否扩张 right
            int j = i + 1;
            while (j < n && right >= intervals[j][0]) {
                right = intervals[j][1] > right ? intervals[j][1] : right;
                j++;
            }
            // 将 left 和 扩张后的 right 添加到 list
            list.add(new int[] { left, right });
            i = j; // 寻找下一个合并区间
        }

        int[][] merged = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            merged[i] = list.get(i);
        }
        return merged;
    }
}
