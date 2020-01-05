package question2;

import DataStruction.ListNode;

public class BitSolution {
//    时间复杂度O(max(m,n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        用哑节点来简化代码，如果没有使用哑节点就需要额外的代码来初始化表头的值
        ListNode dummyHead=new ListNode(0);
        ListNode q=l1,p=l2,curr=dummyHead;
//        进位标志carry
        int carry=0;
        while (q!=null||p!=null){
//          获取节点值，如果节点为空，值就为0
            int x=q==null?0:q.val;
            int y=p==null?0:p.val;
//          两个节点值和进位相加
            int sum=x+y+carry;
//          获取相加之后的进位值
            carry=sum/10;
//          将相加后结果加入结果链表
            curr.next=new ListNode(sum%10);
//          移动到下一个节点
            curr=curr.next;
            if (q!=null){
                q=q.next;
            }
            if (p!=null){
                p=p.next;
            }
        }
//        最后判断是否仍有进位，防止进位被遗漏
        if (carry>0){
            curr.next=new ListNode(carry);
        }
//        因为第一个节点是哑节点，
        return dummyHead.next;
    }
}
