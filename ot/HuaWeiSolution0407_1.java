package ot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// 对N个人进行分组，每个人会写下一个自己最想组队的人的姓名
// 如果满足所有人的要求，那么会被分成几组

// 输入
// Alice Bob
// Bob Chris
// Chris Jack
// Rose Jack
// Jack Rose
// Faker Uzi
// Uzi ClearLove
// ClearLove Uzi

// 输出
// 2组（Alice，Bob，Chris，Jack，Rose 和 Faker， Uzi，ClearLove，Uzi 两组）

// 45% AC
public class HuaWeiSolution0407_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            map.put(in.next(), in.next());
        }
        in.close();
        int n = 0;
        Set<String> keys = map.keySet();
        for (String k : keys) {
            foo(map, map2, k, n++);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer v : map2.values()) {
            set.add(v);
        }
        System.out.println(set.size());

    }

    public static void foo(Map<String, String> map, Map<String, Integer> map2, String key, int i) {
        if (map2.get(key) == null) {
            map2.put(key, i);
            foo(map, map2, map.get(key), i);
        }
    }

}