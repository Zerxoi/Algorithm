package leetcode.problem239;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(new int[] { 1 }, 1)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        int len = nums.length;
        int count = 0;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < len; i++) {
            // 前k-1个元素直接加入优先队列
            queue.add(new int[] { nums[i], i });
            if (i >= k - 1) {
                // 从第k个元素开始要找到最大元素，放入res数组
                int[] peek = queue.peek();
                res[count++] = peek[0];
                // 如果最大元素下标小于下一个窗口的左边界，弹出最大元素
                // 只弹出超出窗口的**最大**元素
                while (peek != null && peek[1] <= i - k + 1) {
                    queue.poll();
                    peek = queue.peek();
                }
            }
        }
        return res;
    }

    // 超出时间限制
    // 因为优先队列使用的堆数据结构，remove操作要先查找要删除的元素，时间O(n)，再对元素进行删除（删除元素与末尾元素调换）进行堆调整，时间复杂度O(logn)
    // public int[] maxSlidingWindow(int[] nums, int k) {
    // PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    // int len = nums.length;
    // int count = 0;
    // int[] res = new int[len - k + 1];
    // for (int i = 0; i < len; i++) {
    // queue.add(nums[i]);
    // if (i >= k - 1) {
    // res[count++] = queue.peek();
    // 弹出超出左侧窗口的元素
    // queue.remove((Integer) nums[i - k + 1]);
    // }
    // }
    // return res;
    // }
}