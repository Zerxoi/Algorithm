package lcof.problem07;

public class Solution {
    public int Fibonacci(int n) {
        int i = 0;
        int j = 1;
        while (n > 0) {
            int tmp = i;
            i = j;
            j = tmp + i;
            n--;
        }
        return i;
    }
}