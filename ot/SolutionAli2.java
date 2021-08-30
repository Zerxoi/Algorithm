package ot;

// import java.util.Scanner;

// Ali OT 感觉 80%以上AC
public class SolutionAli2 {
    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // int n = input.nextInt();
        // int m = input.nextInt();
        // int k = input.nextInt();
        // int[][] table = new int[m][4];
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < 4; j++) {
        // table[i][j] = input.nextInt();
        // }
        // }
        // input.close();

        int n = 3;
        // int m = 3;
        int k = 1;
        int[][] table = new int[][] { { 1, 2, 3, 1 }, { 2, 3, 3, 1 }, { 1, 3, 10, 5 } };
        int[][] costs = new int[k + 1][n];
        for (int i = 0; i < table.length; i++) {
            int[] row = table[i];
            for (int j = 0; j <= k; j++) {
                costs[j][row[1] - 1] = costs[j][row[1] - 1] == 0 ? costs[j][row[0] - 1] + row[2]
                        : Math.min(costs[j][row[1] - 1], costs[j][row[0] - 1] + row[2]);
            }
            for (int j = 0; j < k; j++) {
                costs[j + 1][row[1] - 1] = costs[j + 1][row[1] - 1] == 0 ? costs[j][row[0] - 1] + row[3]
                        : Math.min(costs[j + 1][row[1] - 1], costs[j][row[0] - 1] + row[3]);
            }
        }
        for (int i = 0; i < costs.length; i++) {
            for (int j = 0; j < costs[i].length; j++) {
                System.out.print(costs[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
