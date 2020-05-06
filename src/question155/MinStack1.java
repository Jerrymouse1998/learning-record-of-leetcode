package question155;

import java.util.Stack;

public class MinStack1 {
    //主栈
    Stack<Integer> stack;
    //保存最小元素
    Stack<Integer> min;

    /**
     * initialize your data structure here.
     */
    public MinStack1() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!min.isEmpty()) {
            if (x <= min.peek()) {
                min.push(x);
            }
        } else {
            min.push(x);
        }
    }

    public void pop() {
        int pop = stack.pop();
        if (pop == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
