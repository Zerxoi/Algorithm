public class BinSearch {
    // public int lowBound(int[] nums, int target) {
    // int i = 0;
    // int j = nums.length - 1;
    // while (i <= j) {
    // int mid = i + ((j - i) >> 1);
    // if (nums[mid] < target) {
    // i = mid + 1;
    // } else {
    // j = mid - 1;
    // }
    // }
    // return i;
    // }

    public static void main(String[] args) {
        System.out.println(new BinSearch().lowBound(new int[] { 1, 2, 3, 4, 5, 6, 8 }, 3));
    }

    public int lowBound(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
