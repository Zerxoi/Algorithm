package ot;

import java.util.Arrays;
// import java.util.Scanner;

// Ali OT 感觉能够 80%以上AC
public class SolutionAli1 {
    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // int m = input.nextInt();
        // int n = input.nextInt();
        // String[] list = new String[n];
        // for (int i = 0; i < n; i++) {
        // list[i] = input.next();
        // }
        String[] list = new String[] { "6", "9", "n", "k" };
        Arrays.sort(list);
        backtrace(list, 0, 3, 0, 0, 0, new StringBuilder());
        // input.close();
    }

    public static void backtrace(String[] list, int len, int n, int index, int nn, int cn, StringBuilder sb) {
        if (nn >= 1 && cn >= 2 && len == n) {
            System.out.println(sb.toString());
        }
        if (index >= list.length || len > n) {
            return;
        }

        for (int i = index; i < list.length; i++) {
            sb.append(list[i]);
            if (list[i].charAt(0) >= '0' && list[i].charAt(0) <= '9') {
                backtrace(list, len + 1, n, i + 1, nn + 1, cn, sb);
            } else {
                backtrace(list, len + 1, n, i + 1, nn, cn + 1, sb);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
