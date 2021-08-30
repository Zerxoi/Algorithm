package leetcode.problem60;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(4, 9));
    }

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backtrace(nums, 0, k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public int backtrace(int[] nums, int pos, int n) {
        if (pos == nums.length) {
            return n - 1;
        }
        for (int i = pos; i < nums.length; i++) {
            int tmp = nums[i];
            for (int j = i; pos < j; j--) {
                nums[j] = nums[j - 1];
            }
            nums[pos] = tmp;

            n = backtrace(nums, pos + 1, n);
            if (n == 0) {
                return 0;
            }
            tmp = nums[pos];
            for (int j = pos; j < i; j++) {
                nums[j] = nums[j + 1];
            }
            nums[i] = tmp;
        }
        return n;
    }
}
