package question23;

import DataStruction.ListNode;

public class OneByOneSolution {
    //时间复杂度：O(Nk)   N是节点总数，k是链表数
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0)return null;
        if (lists.length<2)return lists[0];
        ListNode dummy=new ListNode(-1);
        dummy.next=lists[0];
        for (int i=1;i<lists.length;i++){
            ListNode head=dummy,p=dummy.next,q=lists[i];
            while (q!=null&&p!=null){
                if (q.val< p.val){
                    head.next=q;
                    q=q.next;
                }else {
                    head.next=p;
                    p=p.next;
                }
                head=head.next;
            }
            if (q!=null)head.next=q;
            if (p!=null)head.next=p;
        }
        return dummy.next;
    }
}
