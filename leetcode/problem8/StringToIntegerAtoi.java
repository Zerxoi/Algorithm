package leetcode.problem8;

public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        boolean negativeFlag = false;
        int i = 0;
        while (i < length && chars[i] == ' ') {
            i++;
        }
        if (i < length && chars[i] == '-') {
            negativeFlag = true;
            i++;
        } else if (i < length && chars[i] == '+') {
            i++;
        }
        int res = 0;
        while (i < length && chars[i] >= '0' && chars[i] <= '9') {
            int r = chars[i] - '0';
            if (!negativeFlag && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && r > 7)))
                return Integer.MAX_VALUE;
            if (negativeFlag && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && r > 8)))
                return Integer.MIN_VALUE;
            res = 10 * res + chars[i] - '0';
            i++;
        }
        return negativeFlag ? -res : res;
    }
}