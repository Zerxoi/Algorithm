package lcof.problem56;

public class SolutionII {
    public static void main(String[] args) {
        System.out.println(new SolutionII().singleNumber(new int[] { 9, 1, 7, 9, 7, 9, 7 }));
    }

    public int singleNumber(int[] nums) {
        int len = nums.length;
        int[] bits = new int[32];
        for (int i = 0; i < len; i++) {
            int j = 0;
            int num = nums[i];
            while (num != 0) {
                bits[j] += num & 1;
                num >>>= 1;
                j++;
            }
        }
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            ans <<= 1;
            ans += bits[i] % 3;
        }
        return ans;
    }
}
