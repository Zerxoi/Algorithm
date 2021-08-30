package leetcode.problem38;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = countAndSay(n - 1);
        int len = pre.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len;) {
            int j = i;
            while (j < len && pre.charAt(j) == pre.charAt(i)) {
                j++;
            }
            sb.append(j - i).append(pre.charAt(i));
            i = j;
        }
        return sb.toString();
    }
}
