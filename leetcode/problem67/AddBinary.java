package leetcode.problem67;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int l = Math.max(a.length(), b.length());
        int k = 0;
        for (int i = 0; i < l; i++) {
            k += i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            k += i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            if ((k & 1) == 1) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            k /= 2;
        }
        if (k == 1) {
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();
    }

}
