package question86;

import DataStruction.ListNode;

public class Solution {
    //时间复杂度：O(n)
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        //创建两个链表
        ListNode min = new ListNode(-1), max = new ListNode(-1);
        ListNode minP = min, maxP = max;
        //遍历参数链表
        while (head != null) {
            if (head.val < x) {
                minP.next = head;
                minP = head;
            } else {
                maxP.next = head;
                maxP = head;
            }
            head = head.next;
        }
        //连接min和max，注意排除掉两个链表的哑节点
        minP.next = max.next;
        maxP.next = null;
        return min.next;
    }
}
