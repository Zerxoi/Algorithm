package leetcode.problem220;

import java.util.HashMap;
// import java.util.Set;
// import java.util.TreeSet;

public class ContainsDuplicateIII {
    public static void main(String[] args) {
        System.out.println(
                new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[] { 2147483646, 2147483647 }, 3, 3));
    }

    // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    // int len = nums.length;
    // TreeSet<Long> set = new TreeSet<>(); // 创建有序集合，存放 i 元素左边至多 k 个元素
    // for (int i = 0; i < len; i++) {
    // Long ceiling = set.ceiling((long) nums[i] - t); // 返回集合中大于等于 nums[i] - t 的元素
    // if (ceiling != null && ceiling <= (long) nums[i] + t) { // 如果该元素小于等于 nums[i]
    // + t，直接返回 true
    // return true;
    // }
    // set.add((long) nums[i]); // 将 nums[i] 添加到集合
    // if (i >= k) { // 如果数组容量超过 k，删除最前面的元素
    // set.remove((long) nums[i - k]);
    // }
    // }
    // return false;
    // }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        int size = t + 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            int id = getBucketId(num, size);
            // 如果 num 所在桶存在元素，直接返回true
            if (map.get(id) != null) {
                return true;
            }
            // 如果前一个桶存在元素，并且num和前一个桶元素相差小于等于t，直接返回true
            if (map.get(id - 1) != null && (long) num - map.get(id - 1) <= t) {
                return true;
            }
            // 如果下一个桶存在元素，并且下一个桶元素和num相差小于等于t，直接返回true
            if (map.get(id + 1) != null && (long) map.get(id + 1) - num <= t) {
                return true;
            }
            // 如果不能返回结果将 num 放入桶中
            map.put(id, num);
            // 始终保证桶中元素小于等于 k
            if (i >= k) {
                map.remove(getBucketId(nums[i - k], size));
            }
        }
        return false;
    }

    // 确定 num 所在桶的 id
    // 0，1，2，...，size-1 的桶 id 为 0，size，size+1，...，2*size-1 的桶 id 为 1，因此 num >= 0
    // 的话，id = num / size
    // -size,...，-2，-1 的桶 id 为 -1，因此 num < 0 的话，id = (num + 1)/ size -1
    public int getBucketId(int num, int size) {
        if (num >= 0) {
            return num / size;
        }
        return (num + 1) / size - 1;
    }
}
