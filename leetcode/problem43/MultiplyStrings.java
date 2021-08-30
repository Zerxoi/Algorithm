package leetcode.problem43;

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("123", "456"));
    }

    // 从个位开始计算这个位的累加值，累加值超过10会有进位，将其存放在next中
    // 时间复杂度O(mn) 空间复杂度 O(1)
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int next = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len1 + len2 - 1; i++) { // 最少会有 len1+len2-1 位，计算每一位对应的累加值，0表示个位，1表示十位，以此类推
            int sum = 0;
            for (int j = 0; j <= i && j < len2; j++) { // j表示num2中的位，看与num1中的k位能否得到i位的数据并累加到sum
                int k = i - j;
                if (k < len1) {
                    sum += (num1.charAt(len1 - 1 - k) - '0') * (num2.charAt(len2 - 1 - j) - '0');
                } else {
                    continue;
                }
            }
            sum += next; // 计算累加值
            sb.append(sum % 10); // 添加到结果
            next = sum / 10; // 计算进位
        }
        if (next != 0) { // 如果有进位，添加到结果
            sb.append(next);
        }
        return sb.reverse().toString(); // 因为个位先添加到结果中，所以要反转一下
    }
}