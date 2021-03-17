package leetcode.problem4;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out
                .println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        // 奇数需要迭代 (length + 1) / 2 次
        // 偶数需要迭代 (length + 1) / 2 + 1 次
        // 无论奇数还是偶数都需要迭代 length / 2 + 1
        int t = length / 2 + 1;
        int i = 0; // nums1 数组的下标
        int j = 0; // nums2 数组的下标
        int m = 0; // 当前迭代获取的值
        int n = 0; // 上一次迭代获取的值
        while (t > 0) {
            n = m;
            if (i < nums1.length && (j >= nums2.length || nums1[i] <= nums2[j])) {
                m = nums1[i];
                i++;
            } else {
                m = nums2[j];
                j++;
            }
            t--;
        }
        if ((length & 1) == 1) {
            return m;
        }
        return (m + n) / 2.0;
    }
}
