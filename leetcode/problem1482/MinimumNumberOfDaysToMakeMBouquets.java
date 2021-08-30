package leetcode.problem1482;

public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfDaysToMakeMBouquets().minDays(new int[] { 1, 10, 3, 10, 2 }, 3, 1));
    }

    // 二分法 O(nlogn)
    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if (len < m * k) {
            return -1;
        }
        int low = 1;
        int high = 1;
        for (int i = 0; i < len; i++) {
            high = Math.max(high, bloomDay[i]);
        }
        // low 之前都是不能够
        // high 之后都是能够
        while (low <= high) {
            int days = ((high - low) >> 1) + low;
            if (canMake(bloomDay, days, m, k)) {
                high = days - 1;
            } else {
                low = days + 1;
            }
        }
        return low;
    }

    public boolean canMake(int[] bloomDay, int days, int m, int k) {
        int len = bloomDay.length;
        int j = 0;
        for (int i = 0; i < len && m > 0; i++) {
            if (bloomDay[i] <= days) {
                j++;
                if (j == k) {
                    m--;
                    j = 0;
                }
            } else {
                j = 0;
            }
        }
        return m == 0;
    }
}
