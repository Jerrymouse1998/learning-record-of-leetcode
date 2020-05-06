package question155;

public class MinStack3 {
    class Node {
        int value;
        int min;
        Node next;

        public Node(int value, int min) {
            this.min = min;
            this.value = value;
            this.next = null;
        }
    }

    Node head;

    /**
     * initialize your data structure here.
     */
    public MinStack3() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            Node node = new Node(x, Math.min(x, head.min));
            node.next = head;
            head = node;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;
    }
}
