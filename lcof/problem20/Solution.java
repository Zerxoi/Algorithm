package lcof.problem20;

import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> stack = new ArrayList<>();
    int min = Integer.MAX_VALUE;

    public void push(int node) {
        if (node < min) {
            min = node;
        }
        stack.add(node);
    }

    public void pop() {
        int e = stack.remove(stack.size() - 1);
        if (e == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < stack.size(); i++) {
                if (stack.get(i) < min) {
                    min = stack.get(i);
                }
            }
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int min() {
        return min;
    }
}
