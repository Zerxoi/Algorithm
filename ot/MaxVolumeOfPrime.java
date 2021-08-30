package ot;

import java.util.Scanner;

// 帮王总做的，感觉能有70%，80%以上AC
// 长方体的边长和为n，3个边长全为质数，求长方体的最大值
public class MaxVolumeOfPrime {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();

        boolean[] nums = new boolean[n + 1];

        for (int i = 2; i < nums.length; i++) {
            nums[i] = isPrime(i);
        }

        int max = 0;

        for (int i = 2; i < nums.length - 2; i++) {
            if (!nums[i])
                continue;
            int j = i;
            while (j < nums.length && !nums[j]) {
                j++;
            }
            int k = nums.length - 1;
            while (k >= 0 && !nums[k]) {
                k--;
            }
            while (j <= k) { // 双指针法，将时间复杂度从 O(n2) 减少至 O(n)
                while (j < nums.length && !nums[j]) {
                    j++;
                }
                while (k >= 0 && !nums[k]) {
                    k--;
                }
                int sum = i + j + k;
                if (sum == n) {
                    max = max > i * j * k ? max : i * j * k;
                    j++;
                    k--;
                } else if (sum < n) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        System.out.println(max);
    }

    public static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

}