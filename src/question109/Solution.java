package question109;

import DataStruction.ListNode;
import DataStruction.TreeNode;

public class Solution {
    //时间复杂度：O(nlogn) 	每个元素需要访问一次生成树节点，每次生成树节点的时候都需要快慢指针找中点是个O(logn)。
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildBST(head, null);
    }

    private TreeNode buildBST(ListNode head, ListNode tail) {
        //出口
        if (head == tail) return null;
        //快慢指针找中点
        ListNode fast = head, slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow指向链表中点，生成根节点
        TreeNode root = new TreeNode(slow.val);
        //生成左右子树
        root.left = buildBST(head, slow);
        root.right = buildBST(slow.next, tail);
        return root;
    }
}
