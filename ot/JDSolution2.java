package ot;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// 合成大西瓜！
// 时间限制： 3000MS
// 内存限制： 589824KB
// 题目描述：
// 2021年过年，小明在玩合成大西瓜。他听说你会编代码，他想让你帮他拿最高分。但你显然并不会如此编程，所以你想了个简易版的合成大西瓜来糊弄小明。
// 规则是这样的，有一串数字序列，当序列到来时，你们可以选择让数字掉落在左边或者右边。已掉落的只有左右两列。如果掉落到一列的数字和此列原有的顶部数字相同，将会合成一个原来的数字并记1分，不同的数字则会堆积（顶部数字换为新掉落的数字）并不计分。例如，左右两边的顶部元素分别是1，2，此时掉落1，如果你让它掉在左边，左边两个元素1合并，并积一分，如果你让它掉在右边，两边的顶部元素就会变成1，1，并且不计分。
// 小明能提前得知数字序列，请你帮忙计算在现有规则下的最大得分。

// 输入描述
// 第一行一个正整数，n表示数字序列的数字数量。
// 第二行n个正整数ai，表示第i个掉落的数字。
// 1≤n≤1x105 ,1≤ai≤n

// 输出描述
// 输出一个非负整数，表示最大得分。（请在输出时加上换行符）


// 样例输入
// 6
// 1 2 3 1 2 2
// 样例输出
// 2

// 提示
// 将第2，5，6个掉落在右边，剩余的掉落在左边即可得到最大得分，2分。

public class JDSolution2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        input.close();
        // int n = 6;
        // int[] nums = new int[] { 1, 2, 3, 1, 2, 2 };
        System.out.println(backtrace(nums, 0, new LinkedList<>(), new LinkedList<>(), 0));
    }

    public static int backtrace(int[] nums, int pos, Deque<Integer> left, Deque<Integer> right, int count) {
        if (pos == nums.length) {
            return count;
        }
        int max = 0;
        int v = nums[pos];
        int tmp = 0;

        Integer peek = left.peek();
        left.push(v);
        tmp = backtrace(nums, pos + 1, left, right, peek != null && peek == v ? count + 1 : count);
        left.pop();
        max = tmp > max ? tmp : max;

        peek = right.peek();
        right.push(v);
        tmp = backtrace(nums, pos + 1, left, right, peek != null && peek == v ? count + 1 : count);
        right.pop();
        max = tmp > max ? tmp : max;

        return max;
    }
}
