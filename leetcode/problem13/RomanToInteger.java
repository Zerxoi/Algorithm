package leetcode.problem13;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int ret = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'M') {
                if (i - 1 >= 0 && chars[i - 1] == 'C') {
                    ret += 800;
                } else {
                    ret += 1000;
                }
            } else if (chars[i] == 'D') {
                if (i - 1 >= 0 && chars[i - 1] == 'C') {
                    ret += 300;
                } else {
                    ret += 500;
                }
            } else if (chars[i] == 'C') {
                if (i - 1 >= 0 && chars[i - 1] == 'X') {
                    ret += 80;
                } else {
                    ret += 100;
                }
            } else if (chars[i] == 'L') {
                if (i - 1 >= 0 && chars[i - 1] == 'X') {
                    ret += 30;
                } else {
                    ret += 50;
                }
            } else if (chars[i] == 'X') {
                if (i - 1 >= 0 && chars[i - 1] == 'I') {
                    ret += 8;
                } else {
                    ret += 10;
                }
            } else if (chars[i] == 'V') {
                if (i - 1 >= 0 && chars[i - 1] == 'I') {
                    ret += 3;
                } else {
                    ret += 5;
                }
            } else if (chars[i] == 'I') {
                ret += 1;
            }
        }
        return ret;
    }
}
