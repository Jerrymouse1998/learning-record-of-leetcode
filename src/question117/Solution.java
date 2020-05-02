package question117;

import DataStruction.TreeNode2next.Node;

public class Solution {

    public Node connect(Node root) {
        Node curr = root;
        while (curr != null) {
            Node dummy = new Node();
            Node tail = dummy;
            //遍历当前层，判断每个节点是否有左右孩子
            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }
                //遍历当前层
                curr = curr.next;
            }
            //移动curr，遍历下一层
            curr = dummy.next;
        }
        return root;
    }
}
