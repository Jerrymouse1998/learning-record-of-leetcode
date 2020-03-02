package question206;

import DataStruction.ListNode;

public class Solution2 {
    //时间复杂度：O(n)
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null)return head;
        ListNode pre=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return pre;
    }
}
