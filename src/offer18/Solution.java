package offer18;

import DataStruction.ListNode;

public class Solution {
    //时间复杂度：O(n)
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val) return head.next;
        ListNode cur = head.next, pre = head;
        while (cur != null) {
            if (cur.val != val) {
                cur = cur.next;
                pre = pre.next;
            } else {
                pre.next = cur.next;
                break;
            }
        }
        return head;
    }
}
