package question206;

import DataStruction.ListNode;

public class Solution1 {
    //时间复杂度：O(n)
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null)return head;
        ListNode pre=null,curr=head;
        while (curr!= null) {
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}
