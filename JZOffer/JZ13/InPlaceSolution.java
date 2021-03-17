package JZOffer.JZ13;

public class InPlaceSolution {
    public void reOrderArray(int[] array) {
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            if ((array[j] & 1) == 1) {
                int tmp = array[j];
                for (int k = j; k > i; k--)
                    array[k] = array[k - 1];
                array[i++] = tmp;
            }
        }
    }
}