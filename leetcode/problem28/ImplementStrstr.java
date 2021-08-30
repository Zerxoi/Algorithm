package leetcode.problem28;

public class ImplementStrstr {
    public static void main(String[] args) {
        System.out.println(new ImplementStrstr().strStr("", ""));
    }

    // public static int strStr(String haystack, String needle) {
    // int len1 = haystack.length();
    // int len2 = needle.length();
    // for (int i = 0; i < len1 - len2 + 1; i++) {
    // if (haystack.substring(i, i + len2).equals(needle)) {
    // return i;
    // }
    // }
    // return -1;
    // }

    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        for (int i = 0; i <= len1 - len2; i++) {
            if (haystack.substring(i, i + len2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}