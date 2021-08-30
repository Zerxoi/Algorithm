package ot;

import java.util.Scanner;

// 买房
// 时间限制： 3000MS
// 内存限制： 1048576KB
// 题目描述：
// 小美和小团居住的城市有n座房子呈一条直线排列,相邻两房子间隔相同,第i座房子编号为i.小团知道小美的房子可能在某些房子中,他想买一套房子使得距离小美可能所在房子的期望距离尽可能小,同时又不超过k元钱,于是向你求助.



// 输入描述
// 第一行2个正整数n,k如上文所述.

// 第二行n个整数,a1,...,an，分别为第i座房子的价格,若价格为0表示小美可能在这一房子中,且此座房子不可购买.小美出现在所有可能房子中的概率相同。

// 2≤n≤100,0≤ai,k≤100

// 输出描述
// 输出一个正整数,表示小团需购买的房间的编号.数据保证至少有一间房间是小美可能居住的地方且至少有一间房间小团可购买 


// 样例输入
// 5 3
// 4 5 0 3 3
// 样例输出
// 4

public class MeituanSolution1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int cost = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        input.close();
        // int n = 7;
        // int cost = 3;
        // int[] nums = new int[] { 4, 5, 0, 3, 3, 0, 1 };
        int[] table1 = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == 0) {
                table1[i] = table1[i - 1] + nums[i];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && (nums[i + 1] == 0)) {
                table1[i] = table1[i + 1] + nums[i];
            }
        }
        // System.out.println(Arrays.toString(table1));
        int min = 0;
        while (min < n && table1[min] == 0) {
            min++;
        }
        for (int i = min; i < n; i++) {
            if (table1[i] != 0 && table1[i] < table1[min] && table1[i] <= cost) {
                min = i;
            }
        }
        System.out.println(min + 1);
    }

}