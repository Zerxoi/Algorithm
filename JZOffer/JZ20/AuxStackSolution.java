package JZOffer.JZ20;

import java.util.Stack;

public class AuxStackSolution {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> aux = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (!aux.empty() && aux.peek() < node) {
            aux.push(aux.peek());
        } else {
            aux.push(node);
        }
    }

    public void pop() {
        stack.pop();
        aux.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return aux.peek();
    }
}