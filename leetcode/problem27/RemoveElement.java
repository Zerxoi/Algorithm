package leetcode.problem27;

public class RemoveElement {
    // 双指针优化（减少移动次数）
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l <= r) { // 结束条件为 r < l
            if (nums[l] == val) { // 如果 nums[l] == val，l 处存放一个 r 处不等于 val 的值
                if (nums[r] == val) { // r 处等于 val，r 左移
                    r--;
                    continue;
                }
                nums[l] = nums[r--]; // 当 r 处不等于 val 时，将 nums[l] 赋值为 nums[r]，同时 r--
            }
            l++; // 当前 l 处理结束，l++
        }
        return l;
    }

    // 双指针
    // public int removeElement(int[] nums, int val) {
    // int len = nums.length;
    // int count = 0;
    // for (int i = 0; i < len; i++) {
    // if (nums[i] == val) {
    // continue;
    // }
    // nums[count++] = nums[i];
    // }
    // return count;
    // }
}
