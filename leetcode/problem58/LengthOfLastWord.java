package leetcode.problem58;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord(" "));
    }

    public int lengthOfLastWord(String s) {
        int len = s.length();
        int j = len - 1;
        while (j >= 0 && s.charAt(j) == ' ') {
            j--;
        }
        int i = j;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return j - i;
    }
}
