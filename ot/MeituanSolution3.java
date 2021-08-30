package ot;

import java.util.Scanner;

// 消除
// 时间限制： 3000MS
// 内存限制： 786432KB
// 题目描述：
// 给一个长度为n的只包含0和1的序列，每次可以使用魔法消除相邻的3个数。在可以用任意次魔法的前提下，0的个数和1的个数的最大差值为多少？输出这个最大差值。



// 输入描述
// 第一行是一个正整数n，表示序列的长度。

// 第二行是只包含0和1的序列，其长度为n。

// 输出描述
// 输出一个整数，表示这个最大差值。


// 样例输入
// 5
// 00001
// 样例输出
// 3
public class MeituanSolution3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String line = input.next();
        input.close();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int count1 = 0;
            for (int j = i; i < n - 2 && j < i + 3; j++) {
                if (line.charAt(j) == '1') {
                    count1++;
                }
            }
            if (count1 > 1) {
                i += 2;
            } else {
                if (line.charAt(i) == '0') {
                    res++;
                } else {
                    res--;
                }
            }
        }
        System.out.println(res);
    }
}
