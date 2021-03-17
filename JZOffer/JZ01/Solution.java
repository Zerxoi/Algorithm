package JZOffer.JZ01;

public class Solution {
    public boolean Find(int target, int[][] array) {
        int m = array.length;
        if (m == 0)
            return false;
        int n = array[0].length;
        if (n == 0) {
            return false;
        }
        int i = array.length - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}