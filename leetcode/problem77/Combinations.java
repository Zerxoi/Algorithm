package leetcode.problem77;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrace(1, n, k, new ArrayList<>(), lists);
        return lists;
    }

    public void backtrace(int start, int n, int k, List<Integer> list, List<List<Integer>> lists) {
        if (k == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrace(i + 1, n, k - 1, list, lists);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }
}
