package leetcode.problem17;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
    }

    char[][] table = new char[][] { new char[] { 'a', 'b', 'c' }, new char[] { 'd', 'e', 'f' },
            new char[] { 'g', 'h', 'i' }, new char[] { 'j', 'k', 'l' }, new char[] { 'm', 'n', 'o' },
            new char[] { 'p', 'q', 'r', 's' }, new char[] { 't', 'u', 'v' }, new char[] { 'w', 'x', 'y', 'z' } };

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        int length = digits.length();
        if (length == 0) {
            return list;
        }
        backtrack(list, table, digits, 0, new StringBuilder());
        return list;
    }

    public void backtrack(List<String> list, char[][] table, String digits, int index, StringBuilder sb) {
        if (index < digits.length()) {
            char[] chars = table[digits.charAt(index) - '2'];
            for (int i = 0; i < chars.length; i++) {
                sb.append(chars[i]);
                backtrack(list, table, digits, index + 1, sb);
                sb.deleteCharAt(index);
            }
        } else {
            list.add(sb.toString());
        }
    }

}
