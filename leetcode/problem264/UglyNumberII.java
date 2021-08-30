package leetcode.problem264;

// import java.util.Arrays;
// import java.util.HashSet;
// import java.util.PriorityQueue;
// import java.util.Set;

public class UglyNumberII {
    public static void main(String[] args) {
        System.out.println(new UglyNumberII().nthUglyNumber(10));
    }

    // 小根堆（以 logn 复杂度找到最小值）和 集合（去重）
    // public int nthUglyNumber(int n) {
    // PriorityQueue<Long> heap = new PriorityQueue<>();
    // Set<Long> set = new HashSet<>();
    // heap.add(1L);
    // int ugly = 0;
    // while (n > 0) { // 弹出n次
    // long curr = heap.poll(); // 弹出堆最小值
    // ugly = (int) curr;
    // // 如果集合中有相同的元素就不向堆中添加
    // if (set.add(curr * 2)) {
    // heap.add(curr * 2);
    // }
    // if (set.add(curr * 3)) {
    // heap.add(curr * 3);
    // }
    // if (set.add(curr * 5)) {
    // heap.add(curr * 5);
    // }
    // n--;
    // }
    // return ugly;
    // }

    // 动态规划（三指针）
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0; // 定义三个指针，分别对应质因子2，3，5
        for (int i = 1; i < n; i++) {
            int min2 = dp[i2] * 2;
            int min3 = dp[i3] * 3;
            int min5 = dp[i5] * 5;
            int min = Math.min(min2, Math.min(min3, min5)); // 找到其中对应的丑数最小值
            // 最小值和哪一个相等对应指针+1
            if (min == min2) {
                i2++;
            }
            if (min == min3) {
                i3++;
            }
            if (min == min5) {
                i5++;
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }
}
