package JZOffer.JZ13;

public class Solution {
    public void reOrderArray(int[] array) {
        int[] tmp = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                tmp[j++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) {
                tmp[j++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tmp[i];
        }
    }
}
