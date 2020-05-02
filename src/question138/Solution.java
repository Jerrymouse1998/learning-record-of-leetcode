package question138;

import DataStruction.randomListNode.Node;

import java.util.HashMap;

public class Solution {
    //时间复杂度：O(n)    空间复杂度：O(n)
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //保存源节点和克隆节点的映射
        HashMap<Node, Node> map = new HashMap<>();
        //第一次遍历,克隆节点只复制 val
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        //第二次遍历,给克隆节点的 next 和 random 指针赋值
        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}
