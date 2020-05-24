package offer06;

import DataStruction.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class StackSolution {
    //时间复杂度：O(n)    空间复杂度：O(n)
    public int[] reversePrint(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }
}
