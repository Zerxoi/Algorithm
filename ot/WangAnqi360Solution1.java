package ot;

import java.util.Scanner;

public class WangAnqi360Solution1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        int aNum = 0;
        int len = s.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            while (i < len && s.charAt(i) == 'b') { // 忽略字符串开头的b
                i++;
            }
            while (i < len && s.charAt(i) == 'a') { // 统计遇到的a的数目
                i++;
                aNum++;
            }
            if (i < len) { // a之后遇到b了，将操作次数加到sum上
                sum += (1 << aNum) - 1;
            }
        }
        System.out.println(sum);
    }
}
