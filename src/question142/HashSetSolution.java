package question142;

import DataStruction.ListNode;

import java.util.HashSet;

public class HashSetSolution {
    //时间复杂度：O(n)	空间复杂度：O(n)
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (set.contains(p)) {
                return p;
            }
            set.add(p);
            p = p.next;
        }
        return null;
    }
}
