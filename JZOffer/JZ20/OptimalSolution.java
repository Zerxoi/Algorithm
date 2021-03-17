package JZOffer.JZ20;

import java.util.Stack;

public class OptimalSolution {
    Stack<Integer> stack = new Stack<>();
    int min;

    public void push(int node) {
        if (stack.empty()) {
            min = node;
            stack.push(0);
        } else {
            stack.push(node - min);
        }
        if (node < min) {
            min = node;
        }
    }

    public void pop() {
        int pop = stack.pop();
        if (pop < 0) {
            min = min - pop;
        }
    }

    public int top() {
        int peek = stack.peek();
        if (peek < 0)
            return min;
        else
            return min + peek;
    }

    public int min() {
        return min;
    }
}
