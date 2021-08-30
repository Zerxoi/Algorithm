package leetcode.problem57;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] res = new InsertInterval().insert(new int[][] { { 1, 5 } }, new int[] { 2, 7 });
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 高贵的二分法
    // 但是时间复杂度还是 O(N),因为最后要线性遍历
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 确定合并后的最左端
        int i0 = 0;
        int j0 = intervals.length - 1;
        while (i0 <= j0) { // 二分法找到给定插入点左端插入的位置
            int mid = i0 + ((j0 - i0) >> 1);
            if (intervals[mid][0] < newInterval[0]) {
                i0 = mid + 1;
            } else {
                j0 = mid - 1;
            }
        }
        // i0 左侧都是小于 newInterval[0] 的， j0 右侧都是大于等于 newInterval[0] 的，且 i0 = j0 + 1
        // 如果发现 newInterval[0] 位于前一个区间之内，应该延伸左端
        if (j0 >= 0 && intervals[j0][1] >= newInterval[0]) {
            newInterval[0] = intervals[j0][0];
        }

        // 确定合并后的最右端
        int i1 = 0;
        int j1 = intervals.length - 1;
        while (i1 <= j1) { // 同样是采用二分法
            int mid = i1 + ((j1 - i1) >> 1);
            if (intervals[mid][0] < newInterval[1]) {
                i1 = mid + 1;
            } else {
                j1 = mid - 1;
            }
        }
        // i1 左侧都是小于 newInterval[1] 的， j1 右侧都是大于等于 newInterval[1] 的，且 i1 = j1 + 1
        // 如果发现 newInterval[1] 位于前一个区间之内，应该延延伸右端
        if (i1 < intervals.length && intervals[i1][0] == newInterval[1]) {
            newInterval[1] = newInterval[1] > intervals[i1][1] ? newInterval[1] : intervals[i1][1];
        }
        // 如果前一个区间的右端比现有右端还要长，使用前一个的右端
        if (j1 >= 0 && intervals[j1][1] > newInterval[1]) {
            newInterval[1] = newInterval[1] > intervals[j1][1] ? newInterval[1] : intervals[j1][1];
        }

        List<int[]> list = new ArrayList<>();
        int i = 0;
        // 左端插入区间的左端的区间全部插入
        for (; i < intervals.length && intervals[i][0] < newInterval[0]; i++) {
            list.add(intervals[i]);
        }
        // 插入重合后的插入区间
        list.add(newInterval);
        // 跳过右端小于等于重合插入区间的区间
        for (; i < intervals.length && intervals[i][1] <= newInterval[1]; i++) {
        }
        // 插入之后的区间
        for (; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        // 将 List 转化为数组
        return list.toArray(new int[list.size()][2]);
    }
}
