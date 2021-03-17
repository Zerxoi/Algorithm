package JZOffer.JZ09;

public class Solution {
    public int JumpFloorII(int target) {
        int[] arr = new int[target + 1];
        arr[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j];
            }
        }
        return arr[target];
    }

    public int JumpFloorIIUltra(int target) {
        return 1 << (target - 1);
    }
}