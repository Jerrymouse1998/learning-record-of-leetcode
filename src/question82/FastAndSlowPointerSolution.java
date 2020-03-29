package question82;

import DataStruction.ListNode;

public class FastAndSlowPointerSolution {
    //时间复杂度：O(n)
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null)return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode fast=head,slow=dummy;
        while (fast != null) {
            //如果fast和下一个节点的值不同或者fast到达链尾，有两种情况
            if (fast.next == null || fast.val != fast.next.val) {
                //指针相邻
                if (slow.next == fast) {
                    slow=fast;
                }else {//指针不相邻，删除中间的发生重复的节点
                    slow.next=fast.next;
                }
            }
            fast=fast.next;
        }
        return dummy.next;
    }
}
