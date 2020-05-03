package question142;

import DataStruction.ListNode;

public class FastAndSlowPointerSolution {
    //时间复杂度：O(n)	空间复杂度：O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            //无环
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            //第一次相遇
            if (slow == fast) break;
        }
        //重置fast
        fast = head;
        //第二次相遇
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
