package ot;

import java.util.*;

// 为了寻找最佳拍档，我们定义两人名字的缘分值：两人名字左对齐后，对应位置字的拼音的缘分值之和。对于两个拼音s1、s2，通过剔除一些字符使得留下的子串一模一样，被剔除字符之和的最小值即为两个拼音的缘分值。求给定两人名字的缘分值。

// 样例输入
// Zhang San
// Zhan  Ai
// 样例输出
// 563

// 提示
// 字符之和是指对应的ASCII值之和。样例中，Zhang和Zhan去掉‘g’后，剩余子串相等，因此第一个字的缘分值为asc(‘g’)=103；而San和Ai则需全部删除San和Ai，其缘分值为asc(“San”)+asc(“Ai”)=290+170=460。因此Zhang San和Zhan Ai的缘分值为103+460=563。边界场景，一人名字较长者，譬如，Ali Ba Ba和Xie Cheng，那最后一个Ba需要全部剔除掉。
public class CtripSolution1 {

    static int calcSimilarity(String name1, String name2) {
        String[] charsArray1 = name1.split(" ");
        String[] charsArray2 = name2.split(" ");
        int ret = 0;
        for (int i = 0; i < charsArray1.length || i < charsArray2.length; i++) {
            if (i < charsArray1.length && i < charsArray2.length) {
                String chars1 = charsArray1[i];
                String chars2 = charsArray2[i];
                for (int j = 0; j < chars1.length() || j < chars2.length(); j++) {
                    if (j < chars1.length() && j < chars2.length()) {
                        if (chars1.charAt(j) != chars2.charAt(j)) {
                            ret += chars1.charAt(j) + chars2.charAt(j);
                        }
                    } else if (j < chars1.length()) {
                        ret += chars1.charAt(j);
                    } else {
                        ret += chars2.charAt(j);
                    }
                }
            } else if (i < charsArray1.length) {
                String chars = charsArray1[i];
                for (int j = 0; j < chars.length(); j++) {
                    ret += chars.charAt(j);
                }
            } else {
                String chars = charsArray2[i];
                for (int j = 0; j < chars.length(); j++) {
                    ret += chars.charAt(j);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(in.nextLine());
        while (in.hasNextLine()) {
            String name1 = in.nextLine();
            String name2 = in.nextLine();

            int sum = calcSimilarity(name1, name2);
            System.out.println(sum);
        }
        in.close();
    }
}