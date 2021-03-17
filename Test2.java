// 回溯法穷举

public class Test2 {
    public static void main(String[] args) {
        int[] nums = new int[] { 4, 0, 1, 3 };
        backtrace(nums, 0, 0);
    }

    public static void backtrace(int[] nums, int index, int sum) {
        if (index >= nums.length) {
            System.out.println(sum);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            backtrace(nums, index + 1, sum * 10 + nums[index]);
            swap(nums, index, i);
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
