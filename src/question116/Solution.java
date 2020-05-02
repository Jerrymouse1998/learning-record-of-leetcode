package question116;

import DataStruction.TreeNode2next.Node;

public class Solution {
    //时间复杂度：O(n)
    public Node connect(Node root) {
        if (root == null) return root;
        Node p = root;
        //p指向每一层的最左节点
        while (p.left != null) {
            Node temp = p;
            while (temp != null) {
                //第一种情况
                temp.left.next = temp.right;
                //第二种情况
                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;
            }
            p = p.left;
        }
        return root;
    }
}
