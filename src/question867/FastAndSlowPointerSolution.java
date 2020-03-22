package question867;

import DataStruction.ListNode;

public class FastAndSlowPointerSolution {
    //时间复杂度：O(n)
    public ListNode middleNode(ListNode head) {
        ListNode fast=head,slow=head;
        while (fast != null && fast.next != null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
