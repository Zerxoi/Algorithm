package leetcode.problem54;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        System.out.println(
                new SpiralMatrix().spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int n = (Math.min(rows, cols) + 1) / 2; // 计算旋转圈数
        for (int i = 0; i < n; i++) { // 根据圈数打印元素
            for (int j = i; j < cols - i; j++) { // (i,i) -> (i,cols-1-i)
                list.add(matrix[i][j]);
            }
            for (int j = i + 1; j < rows - i; j++) { // (i+1,cols-1-i) -> (rows-1-i,cols-1-i)
                list.add(matrix[j][cols - 1 - i]);
            }
            if (rows - i - 1 > i && cols - i - 1 > i) { // 如果 i==rows-1-i 或者 i==cols-1-i 说明只有一列或者一行，这样不需要重复打印
                for (int j = cols - 2 - i; j > i; j--) { // (rows-1-i,cols-2-i) -> (rows-1-i,i+1)
                    list.add(matrix[rows - 1 - i][j]);
                }
                for (int j = rows - 1 - i; j > i; j--) { // (rows-1-i,i) -> (i+1,i)
                    list.add(matrix[j][i]);
                }
            }
        }
        return list;
    }
}
