package ot;
// 合成宝石

import java.util.Scanner;

// 时间限制： 3000MS
// 内存限制： 589824KB
// 题目描述：
// 小团作为一位宝石收藏家和制造家，对宝石了如指掌。每个宝石拥有不同的等级（1级到6级）。

// 制造：小团可以制造1级宝石，每制造一个1级宝石，需要花费1222个金币来购买原料。

// 合成：小团可以用同等级的宝石来合成更高等级的宝石。具体地，(x+1)个x级的宝石可以合成为一个(x+1)级的宝石，该合成过程需要花费7890*x个金币。

// 为了合成6级宝石，小团购买了n堆低级宝石，同一堆宝石的等级都一样。（不同堆的宝石等级也可能相同）

// 现在告诉你这n堆宝石每堆的数量和等级和激活状态，问如果小团需要m个6级宝石，至少需要花费的金币数量是多少？

// 输入描述
// 第一行是一个整数n，表示有n堆宝石。

// 接下来n行，每行两个整数ai,bi，表示第i堆宝石有ai个，等级为bi(1≤bi≤5)。 

// 最后一行是一个整数m，表示小团想要的6级宝石数量。

// 输出描述
// 一行一个整数，表示最少需要花费的金币数。

// 样例输入
// 1
// 6 2
// 1
// 样例输出
// 6490746
public class MeituanSolution5 {
    public static void main(String[] args) {
        long[] costs = new long[] { 1222, 10334, 46782, 210798, 1085550, 6552750 };
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = input.nextInt();
            nums[i][1] = input.nextInt();
        }
        int m = input.nextInt();
        input.close();
        long cost = m * costs[5];
        for (int i = 0; i < n; i++) {
            cost -= nums[i][0] * costs[nums[i][1] - 1];
        }
        System.out.println(cost);
    }

    public static long cost(int level) {
        if (level == 1) {
            return 1222;
        }
        return level * cost(level - 1) + 7890 * (level - 1);
    }
}
