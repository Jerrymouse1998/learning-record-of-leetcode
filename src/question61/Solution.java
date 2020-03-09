package question61;

import DataStruction.ListNode;

public class Solution {
    //时间复杂度：O(n)
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)return head;
        //标记初始链表的结尾，n记录节点数
        ListNode oldTail=head;
        int n=1;
        while (oldTail.next!=null){
            oldTail=oldTail.next;
            n++;
        }
        //链表成环
        oldTail.next=head;
        //旋转之后的新结尾
        ListNode newTail=head;
        for (int i = 1; i < n - k % n; i++) {
            newTail=newTail.next;
        }
        //新头节点
        ListNode newHead=newTail.next;
        //新尾节点和新头节点之间断开
        newTail.next=null;
        return newHead;
    }
}
