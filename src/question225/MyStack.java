package question225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        this.queue=new LinkedList<>();
    }

    /** Push element x onto stack.
     * O(n) */
    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element.
     * O(1)*/
    public int pop() {
        return queue.poll();
    }

    /** Get the top element.
     * O(1)*/
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty.
     * O(1) */
    public boolean empty() {
        return queue.isEmpty();
    }
}
