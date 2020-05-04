package question146;

public class DoubleLinkedList {
    //头尾哑节点
    Node head, tail;
    //节点个数
    int size;

    public DoubleLinkedList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.next = head;
        size = 0;
    }

    //表头插入节点
    public boolean addFirst(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        size++;
        return true;
    }

    //删除节点(节点是从map映射中拿到的,一定存在)
    public boolean remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
        return true;
    }

    //删除表尾节点
    public Node removeLast() {
        if (head.next == tail) return null;
        Node last = tail.pre;
        remove(last);
        return last;
    }

    public int size() {
        return size;
    }
}
