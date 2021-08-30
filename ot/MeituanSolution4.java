package ot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// 关键串
// 时间限制： 3000MS
// 内存限制： 589824KB
// 题目描述：
// 定义一个字符串为关键串当且仅当该串中出现次数最多的字符严格超过了字符总数（即串长）的一半。

// 例如字符串"a","aab","aaab","abccc"是关键串，而"ab","abc","aabb","abcc"不是。

// 给一个长度为n的字符串s，有多少个子串是关键串？

// 子串：对于一个给定的字符串，串中任意个连续的字符组成的子序列称为该串的子串。



// 输入描述
// 第一行是一个正整数n，表示字符串的长度。

// 第二行是一个长度为n的仅包含小写字母的字符串s。

// 输出描述
// 输出一行，表示字符串s中是关键串的子串个数。


// 样例输入
// 5
// ccccb
// 样例输出
// 14
public class MeituanSolution4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String s = input.next();
        input.close();
        int count = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isKeyString(s, i, j)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isKeyString(String s, int start, int end) {
        int mid = (end - start + 1) / 2;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0) + 1;
            if (count > mid) {
                return true;
            }
            map.put(c, count);
        }
        return false;
    }
}
