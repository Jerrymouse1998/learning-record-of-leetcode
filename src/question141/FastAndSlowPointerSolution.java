package question141;

import DataStruction.ListNode;

public class FastAndSlowPointerSolution {
    //时间复杂度：O(n)	空间复杂度：O(1)
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            //相遇说明有环
            if (fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
