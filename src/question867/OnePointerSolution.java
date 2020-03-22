package question867;

import DataStruction.ListNode;

public class OnePointerSolution {
    //时间复杂度：O(n)
    public ListNode middleNode(ListNode head) {
        //统计节点个数
        int n=0;
        ListNode curr=head;
        while (curr != null) {
            n++;
            curr=curr.next;
        }
        //找到中间位置节点
        int kth=0;
        curr=head;
        while (kth < n / 2) {
            kth++;
            curr=curr.next;
        }
        return curr;
    }
}
