package question445;

import DataStruction.ListNode;

import java.util.Stack;

public class StackSolution {
    //时间复杂度：O(n)	两次遍历。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null)return l2;
        if (l2==null)return l1;
        //参数链表入栈
        Stack<Integer> stack1=new Stack<>(),stack2=new Stack<>();
        while (l1 != null) {
            stack1.add(l1.val);
            l1=l1.next;
        }
        while (l2 != null) {
            stack2.add(l2.val);
            l2=l2.next;
        }
        //依次出栈相加
        int carry=0;
        ListNode dummy=new ListNode(-1);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int x=stack1.isEmpty()?0:stack1.pop();
            int y=stack2.isEmpty()?0:stack2.pop();
            int sum=x+y+carry;
            carry=sum/10;
            //头插法
            ListNode node=new ListNode(sum%10);
            node.next=dummy.next;
            dummy.next=node;
        }
        if (carry != 0) {
            ListNode node=new ListNode(carry);
            node.next=dummy.next;
            dummy.next=node;
        }
        return dummy.next;
    }
}
