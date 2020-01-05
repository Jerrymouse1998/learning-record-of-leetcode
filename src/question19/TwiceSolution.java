package question19;

import DataStruction.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//操作执行了2L-n步，时间复杂度为O(L)。
public class TwiceSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=0;
//        依然是借助哑节点
        ListNode dummy=new ListNode(0),q=head;
        dummy.next=head;
//        第一次遍历获取链表长度
        while (q!=null){
            len++;
            q=q.next;
        }
//        第二次遍历找到待删除节点的前一个节点
        q=dummy;
        len-=n;
        while (len>0){
            len--;
            q=q.next;
        }
//        删除目标节点
        q.next=q.next.next;
        return dummy.next;
    }
}
