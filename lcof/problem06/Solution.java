package lcof.problem06;

public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
            return 0;
        int pre = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < pre) {
                return array[i];
            }
            pre = array[i];
        }
        return pre;
    }
}