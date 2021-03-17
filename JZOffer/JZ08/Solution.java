package JZOffer.JZ08;

public class Solution {
    public int JumpFloor(int target) {
        int i = 1;
        int j = 2;
        while (target > 1) {
            int tmp = i;
            i = j;
            j = tmp + i;
            target--;
        }
        return i;
    }
}