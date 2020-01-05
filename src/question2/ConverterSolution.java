package question2;

import DataStruction.ListNode;

import java.math.BigDecimal;

public class ConverterSolution {
//    时间复杂度O(max(m,n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1="";
        String s2="";
        ListNode q=l1,p=l2;
//        将两个链表转化为字符串
        while (q!=null){
            s1=q.val+s1;
            q=q.next;
        }
        while (p!=null){
            s2=p.val+s2;
            p=p.next;
        }
        BigDecimal x=new BigDecimal(s1);
        BigDecimal y=new BigDecimal(s2);
        BigDecimal z=x.add(y);
//        将结果转换成链表
        char[] chars=z.toString().toCharArray();
        ListNode result=new ListNode(Integer.parseInt(String.valueOf(chars[chars.length-1])));
        ListNode t=result;
//        因为链表是逆序的
        for (int i=chars.length-2;i>=0;i--){
            ListNode temp=new ListNode(Integer.parseInt(String.valueOf(chars[i])));
            t.next=temp;
            t=temp;
        }
        return result;
    }
}
