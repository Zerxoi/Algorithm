package ot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 输入两行数据，分别是一个数字序列和数字序列的依赖关系

// 数字序列表示任务队列，每个数组表示任务队列执行所花费的时间，先进队列的优先被执行
// 如果任务依赖于其他任务要等到依赖任务执行完才能执行该任务
// 输出每个人物的执行完成时间（执行完成时间 = 等待时间 + 任务执行时间）

// 输入
// 1,3,4,5,8,5,3,6
// 0->2,2->4,4->6

// 输出
// 35,3,34,8,16,21,24,30

// 100% AC
public class HuaWeiSolution0407_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] numsStr = input.nextLine().split(",");
        int[] nums = new int[numsStr.length];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.valueOf(numsStr[i]);
        }
        String[] depsStr = input.nextLine().split(",");
        Map<Integer, List<Integer>> deps = new HashMap<>();
        for (int i = 0; i < depsStr.length; i++) {
            String[] tmp = depsStr[i].split("->");
            List<Integer> list = deps.get(Integer.valueOf(tmp[0]));
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(Integer.valueOf(tmp[1]));
            deps.put(Integer.valueOf(tmp[0]), list);
        }
        input.close();
        // int[] nums = new int[] { 1, 3, 4, 5, 8, 5, 3, 6 };
        // Map<Integer, List<Integer>> deps = new HashMap<>();
        // deps.put(0, Arrays.asList(2));
        // deps.put(2, Arrays.asList(4, 6));
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int n = 0;
        boolean[] oks = new boolean[nums.length];
        int[] res = new int[nums.length];
        while (n < nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (oks[i]) { // 执行
                    continue;
                }
                List<Integer> list = deps.get(i); // 没执行，没依赖
                if (list == null) {
                    count += nums[i];
                    oks[i] = true;
                    n++;
                    // sb.append(count + ",");
                    res[i] = count;
                    continue;
                }
                boolean ok = true;
                for (int j = 0; j < list.size(); j++) {
                    if (!oks[list.get(j)]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) { // 没执行，依赖完成
                    count += nums[i];
                    oks[i] = true;
                    n++;
                    // sb.append(count + ",");
                    res[i] = count;
                    continue;
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i] + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
