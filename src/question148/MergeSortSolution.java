package question148;

import DataStruction.ListNode;

public class MergeSortSolution {
    //时间复杂度：O(nlogn)	空间复杂度：O(logn)	递归栈使用的空间。
    public ListNode sortList(ListNode head) {
        //节点为空,或只有一个节点
        if (head == null || head.next == null) return head;
        //快慢指针找到中点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //拆分
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(head2);
        //合并有序链表
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        p.next = left != null ? left : right;
        return dummy.next;
    }
}
