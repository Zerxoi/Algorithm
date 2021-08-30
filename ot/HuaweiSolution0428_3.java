package ot;

import java.util.Scanner;

public class HuaweiSolution0428_3 {
    public static void main(String[] args) {
        // 保存输入
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int x = input.nextInt();
        String[][] ms = new String[m][];
        for (int i = 0; i < m; i++) {
            ms[i] = input.nextLine().split(" ");
        }
        String[] ns = new String[n];
        for (int i = 0; i < n; i++) {
            ns[i] = input.next();
        }
        input.close();

        // 手写测试用例
        // int m = 4;
        // int n = 6;
        // int x = 4;
        // String[][] ms = new String[][] { { "Java", "C++", "Python" }, { "Python" }, {
        // "C++", "Java" }, { "Python" } };
        // String[] ns = new String[] { "Java", "Python", "C++", "Python", "C++", "Java"
        // };

        int[][] table = new int[m][n];
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            String[] langs = ms[i];
            for (String lang : langs) {
                for (int j = 0; j < n; j++) {
                    if (lang.equals(ns[j])) {
                        table[i][j] = 1;
                        rows[i]++;
                        cols[j]++;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (rows[i] <= x) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (cols[j] > 2) {
                    table[i][j] = 0;
                    cols[j]--;
                    rows[i]--;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (rows[i] > x) {
                System.out.println(false);
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            if (cols[i] < 2) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
