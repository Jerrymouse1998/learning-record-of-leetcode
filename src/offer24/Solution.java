package offer24;

import DataStruction.ListNode;

public class Solution {
    //时间复杂度：O(N)
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
