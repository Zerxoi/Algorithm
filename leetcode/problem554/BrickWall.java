package leetcode.problem554;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public static void main(String[] args) {
        System.out.println(new BrickWall().leastBricks(List.of(List.of(1, 2, 2, 1), List.of(3, 1, 2), List.of(1, 3, 2),
                List.of(2, 4), List.of(3, 1, 2), List.of(1, 3, 1, 1))));
    }

    // 超时
    // public int leastBricks(List<List<Integer>> wall) {
    // int m = wall.size();
    // int n = 0;
    // List<Integer> bricks = wall.get(0);
    // for (int i = 0; i < bricks.size(); i++) {
    // n += bricks.get(i);
    // }
    // int[][] counts = new int[m][2];
    // for (int i = 0; i < m; i++) {
    // counts[i][0] += wall.get(i).get(0);
    // counts[i][1]++;
    // }
    // int min = m;
    // for (int j = 1; j < n; j++) {
    // int tmp = m;
    // for (int i = 0; i < m; i++) {
    // if (j == counts[i][0]) {
    // tmp--;
    // if (counts[i][1] < wall.get(i).size()) {
    // counts[i][0] += wall.get(i).get(counts[i][1]++);
    // }
    // }
    // }
    // if (tmp < min) {
    // min = tmp;
    // }
    // }
    // return min;
    // }

    // 数组
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> bricks : wall) {
            int sum = 0;
            for (int i = 0; i < bricks.size() - 1; i++) {
                int width = bricks.get(i);
                sum += width;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (Integer v : map.values()) {
            if (v > max) {
                max = v;
            }
        }
        return wall.size() - max;
    }
}
