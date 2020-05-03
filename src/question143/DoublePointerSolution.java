package question143;

import DataStruction.ListNode;

import java.util.ArrayList;

public class DoublePointerSolution {
    //时间复杂度：O(n)	两次遍历。
    //空间复杂度：O(n)
    public void reorderList(ListNode head) {
        if (head == null) return;
        //存入数组
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        //双指针重排
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            list.get(j).next = list.get(i);
            j--;
        }
        //新的表尾节点
        list.get(i).next = null;
    }

}
