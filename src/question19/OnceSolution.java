package question19;

import DataStruction.ListNode;

public class OnceSolution {
    public static void main(String[] args) {
//        [1,2,3,4,5]
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        ListNode a5=new ListNode(5);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        ListNode res= new OnceSolution().removeNthFromEnd(a1,2);
        while (res!=null){
            System.out.print(res.val);
            res=res.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode p=dummy;
        ListNode q=dummy;
//        首先让q指针移动到和p指针间隔n个元素的位置
        for (int i=1;i<=n+1;i++){
            q=q.next;
        }
//        此时让p和q保持间距的情况下，同时向后移动，直到q为null
        while (q!=null){
            q=q.next;
            p=p.next;
        }
//        删除目标节点
        p.next=p.next.next;
        return dummy.next;
    }
}
