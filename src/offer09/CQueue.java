package offer09;

import java.util.Deque;
import java.util.LinkedList;

public class CQueue {
    Deque<Integer> stackA, stackB;
    int size;

    public CQueue() {
        this.stackA = new LinkedList<>();
        this.stackB = new LinkedList<>();
        this.size = 0;
    }

    //时间复杂度：O(n)
    public void appendTail(int value) {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
        stackA.push(value);
        while (!stackB.isEmpty()) {
            stackA.push(stackB.pop());
        }
        size++;
    }

    //时间复杂度：O(1)
    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        size--;
        return stackA.pop();
    }
}
