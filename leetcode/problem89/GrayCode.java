package leetcode.problem89;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(3));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>(1 << n);
        list.add(0);
        int size = 1;

        for (int i = 0; i < n; i++) {
            for (int j = size - 1; j >= 0; j--) {
                list.add((1 << i) + list.get(j));
            }
            size = size << 1;
        }
        return list;
    }

}
