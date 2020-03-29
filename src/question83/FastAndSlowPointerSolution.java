package question83;

import DataStruction.ListNode;

public class FastAndSlowPointerSolution {
    //时间复杂度：O(n)
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null)return head;
        ListNode curr=head,next=head.next;
        while (next != null) {
            if (curr.val != next.val) {
                curr=curr.next;
            }else {
                curr.next=next.next;
            }
            next=next.next;
        }
        return head;
    }
}
