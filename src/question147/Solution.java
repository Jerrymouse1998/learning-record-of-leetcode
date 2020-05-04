package question147;

import DataStruction.ListNode;

public class Solution {
    //时间复杂度：O(n^2)	插入排序
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            //当发生逆序的时候才需要进行插入排序
            if (next != null && next.val < cur.val) {
                //pre 寻找 next 节点插入的位置的前驱
                while (pre.next != null && pre.next.val <= next.val) {
                    pre = pre.next;
                }
                //插入操作,next 插入到 pre节点的后面
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                //pre 指针重置
                pre = dummy;
            } else {
                //当前是有序的,不需要插入排序
                cur = next;
            }
        }
        return dummy.next;
    }
}
