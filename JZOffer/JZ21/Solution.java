package JZOffer.JZ21;

import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0; // 入栈的元素索引
        int j = 0; // 弹出的元素索引
        // 弹出元素索引会在入栈元素入栈并弹出后加 1，因此以 i 为结束条件
        while (i < pushA.length) {
            if (!stack.empty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            } else if (pushA[i] != popA[j]) {
                stack.push(pushA[i]);
                i++;
            } else {
                // 省略入栈后弹出，直接到下一个入栈元素和弹出元素
                i++;
                j++;
            }
        }
        // 入栈后如果栈里还有元素，其弹出顺序应该和 popA 数组剩余元素一致
        while (!stack.empty()) {
            if (stack.pop() != popA[j++]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 2, 3, 4, 5 };
        int[] arr2 = new int[] { 4, 3, 5, 1, 2 };
        boolean res = new Solution().IsPopOrder(arr1, arr2);
        System.out.println(res);
    }
}
