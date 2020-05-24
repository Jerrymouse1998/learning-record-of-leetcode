package offer06;

import DataStruction.ListNode;

import java.util.ArrayList;

public class RecusionSolution {
    //时间复杂度：O(n)    空间复杂度：O(n)
    ArrayList<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recusion(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void recusion(ListNode head) {
        if (head == null) return;
        recusion(head.next);
        list.add(head.val);
    }
}
