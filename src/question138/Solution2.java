package question138;

import DataStruction.randomListNode.Node;

public class Solution2 {
    //时间复杂度：O(n)    空间复杂度：O(1)
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //克隆源节点
        Node p = head;
        while (p != null) {
            Node temp = p.next;
            p.next = new Node(p.val);
            p.next.next = temp;
            p = temp;
        }
        //给克隆节点的 random 赋值
        p = head;
        while (p != null) {
            if (p.random != null) p.next.random = p.random.next;
            p = p.next.next;
        }
        //拆分
        p= head;
        Node cloneHead = p.next;
        Node cloneP = cloneHead;
        while (cloneP.next != null) {
            //原链表
            p.next = p.next.next;
            p=p.next;
            //克隆链表
            cloneP.next = cloneP.next.next;
            cloneP = cloneP.next;
        }
        //最后不要忘了给原链表收尾
        p.next = null;
        return cloneHead;
    }
}
