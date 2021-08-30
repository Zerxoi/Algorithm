package lcof.problem06;

public class BinSearchSolution {
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 2);
            if (array[mid] > array[hi]) {
                lo = mid + 1;
            } else if (array[lo] > array[mid]) {
                hi = mid;
            } else {
                hi--;
            }
        }
        return array[lo];
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(minNumberInRotateArray(new int[] { 3, 4, 5, 1, 2 }));
    }
}
