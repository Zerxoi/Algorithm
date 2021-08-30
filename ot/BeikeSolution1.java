package ot;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BeikeSolution1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        input.close();
        // int[] nums = new int[] { 6, 6, 6 };
        // int n = nums.length;
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Set<Integer> set = new HashSet<>();
        backtrace(nums, order, 0, n, set);
        System.out.println(set.size());
    }

    public static void backtrace(int[] nums, int[] order, int pos, int n, Set<Integer> set) {
        if (pos == n) {
            int k = order[0];
            int sum = nums[order[0]];
            for (int i = 1; i < n; i++) {
                if (sum < nums[order[i]]) {
                    k = order[i];
                }
                sum += nums[order[i]];
            }
            set.add(k);
            return;
        }
        for (int i = pos; i < n; i++) {
            int tmp = order[i];
            order[i] = order[pos];
            order[pos] = tmp;
            backtrace(nums, order, pos + 1, n, set);
            tmp = order[i];
            order[i] = order[pos];
            order[pos] = tmp;
        }
    }
}
