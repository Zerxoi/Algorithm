package binarySearch;

public class Test {
    public static int lowerBound(int[] array, int target) {
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (array[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] array = new int[] { -1, 0, 0, 3, 3, 3, 7, 8, 9 };
        System.out.println(lowerBound(array, 3));
    }
}
