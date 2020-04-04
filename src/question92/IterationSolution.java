package question92;

import DataStruction.ListNode;

public class IterationSolution {
    //时间复杂度：O(n)
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //待翻转链表的头节点的前驱
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) pre = pre.next;
        //待翻转链表
        ListNode start = pre.next, end = pre.next;
        for (int i = 0; i < n - m; i++) end = end.next;
        //待翻转链表的后继
        ListNode next = end.next;
        //断开待翻转链表
        end.next = null;
        //翻转完成后拼接回原链表
        pre.next = reverse(start);
        start.next = next;
        return dummy.next;
    }

    //翻转链表
    private ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
