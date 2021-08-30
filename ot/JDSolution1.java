package ot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


// 交叉
// 时间限制： 3000MS
// 内存限制： 589824KB
// 题目描述：
// 定义一个点为t直线交点当且仅当该点的横纵坐标为非负整数且刚好有t条直线经过该点。

// 给出平面上n条相互不重合的直线的斜截式y=kx+b,询问对于（2≤t≤n），t直线交点的数量。

// 样例解释：

// 蓝线和绿线在 (1,3) 交叉，红线与绿线在 (2,6) 交叉。由于红线和蓝线的交叉点横坐标不是整数，所以不计入答案。所以两直线交点一个，三直线交点零个。

// 输入描述
// 第一行一个整数n（1≤n≤104），表示一共有n条直线。

// 接下来n行，每行包括两个整数ki（0≤ki≤102）和bi（0≤bi≤102）表示直线的斜率和截距。

// 输出描述
// 一行输出n-1个数，第一个数表示平面上两直线交点的数量，第二个数表示三直线交点的数量，以此类推。

// 样例输入
// 3
// 2 2
// 3 0
// 0 3
// 样例输出
// 2 0

public class JDSolution1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                nums[i][j] = input.nextInt();
            }
        }
        input.close();
        // int n = 3;
        // int[][] nums = new int[][] { { 2, 2 }, { 3, 0 }, { 0, 3 } };
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = 0;
                int y = 0;
                int tmp1 = nums[i][1] - nums[j][1];
                int tmp2 = nums[j][0] - nums[i][0];
                if (tmp2 == 0) {
                    continue;
                }
                if (tmp1 % tmp2 == 0) {
                    x = tmp1 / tmp2;
                    y = nums[i][0] * x + nums[i][1];
                    if (x >= 0 && y >= 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(x);
                        list.add(y);
                        map.put(list, 0);
                    }
                }
            }
        }
        Iterator<List<Integer>> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            List<Integer> list = keys.next();
            int count = 0;
            for (int i = 0; i < n; i++) {
                int x = list.get(0);
                int y = list.get(1);
                if (y == nums[i][0] * x + nums[i][1]) {
                    count++;
                }
            }
            map.put(list, count);
        }
        int[] res = new int[n - 1];
        Iterator<Integer> values = map.values().iterator();
        while (values.hasNext()) {
            int v = values.next();
            for (int i = 0; i < v - 1; i++) {
                res[i]++;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
