package question199;

import DataStruction.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSSolution {
    //时间复杂度：O(n)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                //只保存每层最后一个元素
                if (i == size - 1) res.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
        }
        return res;
    }
}
