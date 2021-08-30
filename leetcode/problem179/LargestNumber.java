package leetcode.problem179;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[] { 3, 314, 3144, 31444, 34, 33, 32, 5, 9 }));
    }

    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        Integer[] integers = new Integer[nums.length]; // 因为无法对 int[] 进行排序，所以先将其转为 Integer[]
        for (int i = 0; i < nums.length; i++) {
            integers[i] = nums[i];
        }
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) { // 根据o1和o2两个数的拼接结果决定排列顺序
                int s1 = 10;
                int s2 = 10;
                while (s1 <= o1) {
                    s1 *= 10;
                }
                while (s2 <= o2) {
                    s2 *= 10;
                }
                return o2 * s1 + o1 - o1 * s2 - o2;
            }

        });
        if (integers[0] == 0) {
            return "0";
        }
        for (int i = 0; i < integers.length; i++) {
            sb.append(integers[i]);
        }
        return sb.toString();
    }
}
