package leetcode.problem6;

public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("ABCD", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int length = s.length();
        int cycleLen = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < length; j += cycleLen) {
                if (j + i < length) {
                    sb.append(s.charAt(j + i));
                }
                if ((i > 0 && i < numRows - 1) && j + cycleLen - i < length) {
                    sb.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return sb.toString();
    }
}
