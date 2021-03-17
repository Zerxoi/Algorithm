package JZOffer.JZ10;

public class Solution {
    public int rectCover(int target) {
        if (target == 0)
            return 0;
        int i = 1;
        int j = 2;
        while (target > 1) {
            int tmp = i;
            i = j;
            j = tmp + j;
            target--;
        }
        return i;
    }
}