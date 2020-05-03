package question143;

import DataStruction.ListNode;

public class MidReverseSolution {
    //时间复杂度：O(n)	快慢指针O(n) + 翻转链表O(n) + 连接链表O(n)
    //空间复杂度：O(1)
    public void reorderList(ListNode head) {
        if (head == null) return;
        //快慢指针找中点,O(logn)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //拆成两个链表
        ListNode head2 = slow.next;
        slow.next = null;
        //翻转第二个链表
        head2 = reverse(head2);
        //依次逐个节点连接两个链表
        while (head2 != null) {
            ListNode next2 = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = head2.next;
            head2 = next2;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
