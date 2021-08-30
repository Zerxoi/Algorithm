package ot;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class BeikeSolution2 {
    static int min = Integer.MAX_VALUE;
    static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int m = input.nextInt();
        int[][] b = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = input.nextInt();
            }
        }
        input.close();
        // int n = 4;
        // int[] a = new int[] { 10, 20, 30, 40 };
        // int m = 3;
        // int[][] b = new int[][] { { 1, 5, 1, 10 }, { 20, 38, 20, 30 }, { 20, 15, 37,
        // 39 } };
        backtrace(a, b, 0, m, n, new int[n], 0, new ArrayList<>());
        System.out.println(min);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }

    public static void backtrace(int[] a, int[][] b, int pos, int m, int n, int[] tmp, int count, List<Integer> list) {
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            if (tmp[i] < a[i]) {
                ok = false;
            }
        }
        if (ok) {
            if (count < min) {
                min = count;
                res.clear();
                for (int i = 0; i < list.size(); i++) {
                    res.add(list.get(i));
                }
            }
            return;
        }
        for (int i = pos; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j] += b[i][j];
            }
            list.add(i + 1);
            backtrace(a, b, i + 1, m, n, tmp, count + 1, list);
            list.remove(list.size() - 1);
            for (int j = 0; j < n; j++) {
                tmp[j] -= b[i][j];
            }
        }
    }
}
