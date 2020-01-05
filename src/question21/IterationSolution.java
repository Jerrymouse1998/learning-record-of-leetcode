package question21;

import DataStruction.ListNode;

public class IterationSolution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null)return l2;
        if (l2==null)return l1;
        ListNode dummy=new ListNode(0);
        ListNode prehead=dummy,p=l1,q=l2;
        while (p!=null&&q!=null){
            if (p.val<q.val){
                prehead.next=p;
                prehead=prehead.next;
                p=p.next;
            }else {
                prehead.next=q;
                prehead=prehead.next;
                q=q.next;
            }
        }
//        最后检查p或者q是否有不为null的指针
        if (p!=null)prehead.next=p;
        if (q!=null)prehead.next=q;
        return dummy.next;
    }
}
