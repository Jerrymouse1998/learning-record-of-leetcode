package question24;

import DataStruction.ListNode;

public class BackTrackSolution {

    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode next=head.next;
        head.next=swapPairs(next.next);
        next.next=head;
        return next.next;
    }
}
