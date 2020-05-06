package question155;

import java.util.Stack;

public class MinStack2 {
    Stack<Integer> stack;
    int min;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        Integer pop = stack.pop();
        if (pop == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
