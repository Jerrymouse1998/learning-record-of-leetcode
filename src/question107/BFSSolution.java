package question107;

import DataStruction.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSSolution {
    //时间复杂度：O(n)	层序遍历。
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //层序遍历
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            //头插法保存每一层的遍历结果到结果集中
            res.add(0, list);
        }
        return res;
    }
}
