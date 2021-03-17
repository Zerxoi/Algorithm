package leetcode.problem22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrace(new StringBuilder(), list, 0, 0, n);
        return list;
    }

    public void backtrace(StringBuilder sb, List<String> list, int open, int close, int n) {
        if (sb.length() == 2 * n) {
            list.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            backtrace(sb, list, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (open > close) {
            sb.append(')');
            backtrace(sb, list, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
