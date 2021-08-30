package ot;

// import java.util.Scanner;

// 帮王总做的，感觉 40%以下 AC，有硬伤
// 小数转分数
public class WangAnqiSolution0407 {
    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // String line = input.nextLine();
        // input.close();
        String line = "0.3(3)";
        int dot = line.indexOf(".");
        int kuohao = line.indexOf("(") != -1 ? line.indexOf("(") : line.length();
        int fenzi = Integer.valueOf(line.substring(dot + 1, kuohao));
        int fenmu = 1;
        for (int i = 0; i < kuohao - dot - 1; i++) {
            fenmu *= 10;
        }
        int ykuohao = line.indexOf(")");
        String xunhuan = line.substring(kuohao + 1, ykuohao);
        boolean flag = true;
        for (int i = 0; i < xunhuan.length(); i++) {
            if (xunhuan.charAt(i) != '3') {
                flag = false;
            }
        }
        if (flag) {
            fenmu *= 3;
            fenzi = fenzi * 3 + 1;
        }
        System.out.println(fenzi + "    " + fenmu);
        for (int i = 2; i <= fenzi; i++) {
            while (fenzi % i == 0 && fenmu % i == 0) {
                fenmu /= i;
                fenzi /= i;
            }
        }
        System.out.println(fenzi + "/" + fenmu);
    }
}
