package leetcode.problem1486;

public class XorOperationInAnArray {
    public static void main(String[] args) {
        System.out.println(new XorOperationInAnArray().xorOperation(10, 5));
    }

    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= start + 2 * i;
        }
        return res;
    }
}
