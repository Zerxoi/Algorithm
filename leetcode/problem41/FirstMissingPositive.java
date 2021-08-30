package leetcode.problem41;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[] { 2, 1, 4, 5, 7, -1 }));
    }

    // 标记法
    // 有效元素 [1,N]， 无用元素 N+1 以上， 被标记的元素 [-N,-1]，因为被标记的元素也要被使用，使用负号标记就很好
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) { // 数组元素为 [1,len+1],其中有效元素是 [1,len]
            if (nums[i] <= 0) { // 将数组中小于等于 0 的元素变成 len+1
                nums[i] = len + 1;
            }
        }
        for (int i = 0; i < len; i++) { // 将 [-len, -1] 和 [1,len] 的元素使用变符号来标记,其中 [-len，-1] 表示其索引位置 i 对应的 i + 1 元素存在
            int num = Math.abs(nums[i]);
            if (num <= len) {
                nums[num - 1] = nums[num - 1] < 0 ? nums[num - 1] : -nums[num - 1];
            }
        }
        for (int i = 0; i < len; i++) { // 遍历第一个没被标记的元素
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return len + 1;
    }

    // 置换法
    // 如果元素在 [1,N] 之间，将元素与目的地位置元素置换
    // public int firstMissingPositive(int[] nums) {
    // int len = nums.length;
    // for (int i = 0; i < nums.length;) {
    // int tmp = nums[i];
    // if (1 <= tmp && tmp <= len) { // 元素在 [1,len] 之间才置换
    // if (tmp == i + 1) { // 满足要求直接跳过
    // i++;
    // } else { // 置换元素
    // if (nums[i] == nums[tmp - 1]) { // 如果两个置换元素一样就直接跳过，避免死循环
    // i++;
    // continue;
    // }
    // nums[i] = nums[tmp - 1];
    // nums[tmp - 1] = tmp;
    // }
    // } else {
    // i++;
    // }

    // }
    // for (int i = 0; i < len; i++) { // 找到第一个不满足条件的数并返回
    // if (nums[i] != i + 1) {
    // return i + 1;
    // }
    // }
    // return len + 1;
    // }

}
