package leetcode.problem55;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[] { 2, 3, 1, 1, 4 }));
    }

    // public boolean canJump(int[] nums) {
    // int len = nums.length;
    // for (int i = len - 2; i >= 0; i--) { // 最后一个元素无论是多少都可以，因为已经到终点了
    // if (nums[i] == 0) { // 如果 i 位置的元素为零，看 i 位置之前有没有一个 j 位置，能够跳过 i 位置
    // int j = i - 1;
    // while (j >= 0 && nums[j] <= i - j) {
    // j--;
    // }
    // if (j < 0) { // 没有直接返回 false
    // return false;
    // } else { // 有的话，下次i从j-1（因为for循环有个i--）开始继续
    // i = j;
    // }
    // }
    // }
    // return true;
    // }

    // 贪心算法(同45题 跳跃游戏II，只不过加了一个最长长度等于终结长度的判断)
    // 时间复杂度 O(N) 空间复杂度 O(1)
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int j = 0;
        int longest = 0;
        for (int i = 0; i < len - 1; i++) { // 该次跳跃的可选范围[i,j]
            longest = Math.max(longest, i + nums[i]);
            if (i == j) {
                if (longest == j) { // 可选范围都遍历完后发现最长长度还是j，说明跳不出去了
                    return false;
                }
                j = longest;
            }
        }
        return true;
    }
}
