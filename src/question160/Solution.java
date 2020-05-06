package question160;

import DataStruction.ListNode;

public class Solution {
    //时间复杂度：O(n)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        //找到交点 或者 pa和pb第二次遍历都完成 时跳出循环
        while (pa != pb) {
            //pa 或 pb 遍历完成后指向另一条链表
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
}
