package question25;

import DataStruction.ListNode;

public class Solution {
    //时间复杂度：O(nk)   n是节点总数
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==1)return head;
        //初始化哑节点、pre、end
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy,end=dummy;
        while (end.next!=null){
            //移动end指向待翻转子链表的尾部,如果剩余节点不足k个，则翻转完成返回head
            for (int i = 0; i < k&& end!=null; i++) end=end.next;
            if (end==null)break;
            //start指向待翻转子链表头节点，next指向未翻转部分的头节点
            ListNode start=pre.next,next=end.next;
            end.next=null;
            pre.next=reverse(start);
            //连接完成翻转部分和未翻转部分
            start.next=next;
            //移动pre和end
            pre=start;
            end=pre;
        }
        return dummy.next;
    }
    //翻转子链表
    private ListNode reverse(ListNode head) {
        ListNode pre=null,curr=head;
        while (curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}
