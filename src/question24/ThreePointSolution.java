package question24;

import DataStruction.ListNode;

public class ThreePointSolution {

    public static void main(String[] args) {
//        [1,2,3,4]
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        ListNode res= new ThreePointSolution().swapPairs(a1);
        while (res!=null){
            System.out.print(res.val+",");
            res=res.next;
        }
    }
//    时间复杂度：O(n)
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        while (pre.next!=null&&pre.next.next!=null){
            ListNode start=pre.next,end=pre.next.next;
//            交换两个节点，注意交换顺序，否则容易死循环
            pre.next=end;
            start.next=end.next;
            end.next=start;
//            移动pre指针，此时已经交换过两个节点的位置
            pre=start;
        }
        return dummy.next;
    }
}
