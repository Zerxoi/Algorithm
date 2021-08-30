package ot;

import java.util.Scanner;

public class BeikeSolution4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] a = new int[n];
        int[][] b = new int[m][3];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i][0] = input.nextInt();
            b[i][1] = input.nextInt();
            b[i][2] = input.nextInt();
        }
        input.close();
    }

    // public static int backtrace(int[] a, int[][] b, int pos,int n, List<Integer> list) {

    //     int res = Integer.MAX_VALUE;
    //     for (int i = 0; i < b.length; i++) {
    //         backtrace(a, b, pos, n, list)
    //     }
    //     return res;
    // }
}
