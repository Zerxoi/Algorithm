package ot;

import java.util.Scanner;

public class BeikeSolution3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            String s = input.next();
            int[] nums = new int[s.length()];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = s.charAt(j) - '0';
            }
            int m = input.nextInt();
            System.out.println(backtrace(nums, m, Integer.valueOf(s)));
        }
        input.close();
    }

    public static int backtrace(int[] nums, int m, int min) {
        if (m == 0) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum = sum * 10 + nums[i];
            }
            return sum;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            swap(nums, i, i + 1);
            int res = backtrace(nums, m - 1, min);
            if (res < min) {
                min = res;
            }
            swap(nums, i, i + 1);
        }
        return min;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
