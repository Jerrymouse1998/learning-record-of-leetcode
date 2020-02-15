package question23;

import DataStruction.ListNode;

public class DivideAndConquerSolution {
    //时间复杂度：O(Nlogk)	N是节点总数，每次对折合并所有节点都参与了，一共对折合并了logk次
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (lists==null|| len ==0)return null;
        while (len>1){
            for (int i=0;i<len/2;i++){
                //中心对称，两两合并
                lists[i]=mergeTwoList(lists[i],lists[len-1-i]);
            }
            len=(len+1)/2;
        }
        return lists[0];
    }
    //合并两个链表
    public ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(-1);
        ListNode head=dummy,p=l1,q=l2;
        while (p!=null&&q!=null){
            if (p.val<q.val){
                head.next=p;
                p=p.next;
            }else {
                head.next=q;
                q=q.next;
            }
            head=head.next;
        }
        if (q!=null)head.next=q;
        if (p!=null)head.next=p;
        return dummy.next;
    }
}
