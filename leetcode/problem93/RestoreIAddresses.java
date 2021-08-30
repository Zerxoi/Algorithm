package leetcode.problem93;

import java.util.ArrayList;
import java.util.List;

public class RestoreIAddresses {
    public static void main(String[] args) {
        System.out.println(new RestoreIAddresses().restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        backtrace(s, 0, 4, list, new StringBuilder());
        return list;
    }

    public void backtrace(String s, int pos, int n, List<String> list, StringBuilder sb) {
        if (n == 0) {
            if (pos == s.length()) {
                sb.deleteCharAt(sb.length()-1);
                list.add(sb.toString());
            }
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if ((s.charAt(pos) == '0' && i - pos > 0) || Integer.valueOf(s.substring(pos, i + 1)) > 255) {
                return;
            }
            int size = sb.length();
            sb.append(s.substring(pos, i + 1) + ".");
            backtrace(s, i + 1, n - 1, list, sb);
            sb.delete(size, sb.length());
        }
    }
}
