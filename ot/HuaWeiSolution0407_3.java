package ot;

import java.util.Scanner;

// 给定一个 m*n 的元素大于 0 的二维数组和花销 cost
// 获取从 [0,0] 出发，到达 [m-1,n-1] 经过的元素之和，该元素之和要小于 cost 并且最接近 cost

// 78% AC
public class HuaWeiSolution0407_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int cost = input.nextInt();
        int[][] table = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = input.nextInt();
            }
        }
        input.close();
        System.out.println(backtrace(table, m, n, 0, 0, 0, cost));
    }

    public static long backtrace(int[][] table, int m, int n, int posi, int posj, long count, int cost) {
        if (posi == m - 1 && posj == n - 1) {
            count = count + table[m - 1][n - 1];
            if (count <= cost) {
                return count;
            } else {
                return -1;
            }
        }
        long r1 = 0;
        long r2 = 0;
        if (posi + 1 < m)
            r1 = backtrace(table, m, n, posi + 1, posj, count + table[posi][posj], cost);
        if (posj + 1 < n)
            r2 = backtrace(table, m, n, posi, posj + 1, count + table[posi][posj], cost);
        return r1 > r2 ? r1 : r2;
    }
}
