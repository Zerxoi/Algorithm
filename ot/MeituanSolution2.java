package ot;

import java.util.Scanner;


// 比赛
// 时间限制： 3000MS
// 内存限制： 786432KB
// 题目描述：
// M队和T队将要进行射箭比赛，M队的队长是小美，T队的队长是小团。这场射箭比赛的规则是，每个队员都可以选择一个距离进行射击，若射中靶心且距离小于等于d则团队得1分，若射中靶心且距离大于d则团队得2分。小团对敌我情况了如指掌，他知道接下来M队将会有n名队员射中靶心，且知道这些队员选择的射箭距离，以及自己所带领的T队会有m名队员射中靶心和他们选择的射箭距离。假定d的值可以由小团确定（d的范围恒为[1,1000]），小团想知道自己的队伍最多能赢小美的队伍多少分（T队得分减去M队得分的最大值）。



// 输入描述
// 第一行两个正整数n，m，分别表示M队射中靶心的队员个数和T队射中靶心的队员个数。

// 接下来一行n个整数a1,a2,...,an表示M队中n个队员的射箭距离。

// 在接下来一行m个整数b1,b2,...,bm表示T队中m个队员的射箭距离。

// 输出描述
// 一行一个整数，表示T队最多能赢M队的分数。


// 样例输入
// 2 3
// 585 375
// 936 317 185
// 样例输出
// 2
public class MeituanSolution2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] nTeam = new int[n];
        int[] mTeam = new int[m];
        for (int i = 0; i < n; i++) {
            nTeam[i] = input.nextInt();
        }
        for (int i = 0; i < m; i++) {
            mTeam[i] = input.nextInt();
        }
        input.close();

        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = nTeam[i];

            long dif = 0;
            for (int j = 0; j < m; j++) {
                if (mTeam[j] <= tmp) {
                    dif++;
                } else {
                    dif += 2;
                }
            }
            for (int j = 0; j < n; j++) {
                if (nTeam[j] <= tmp) {
                    dif--;
                } else {
                    dif -= 2;
                }
            }
            max = max > dif ? max : dif;
        }
        for (int i = 0; i < m; i++) {
            int tmp = mTeam[i];

            long dif = 0;
            for (int j = 0; j < m; j++) {
                if (mTeam[j] <= tmp) {
                    dif++;
                } else {
                    dif += 2;
                }
            }
            for (int j = 0; j < n; j++) {
                if (nTeam[j] <= tmp) {
                    dif--;
                } else {
                    dif -= 2;
                }
            }
            max = max > dif ? max : dif;
        }
        System.out.println(max);
    }
}
