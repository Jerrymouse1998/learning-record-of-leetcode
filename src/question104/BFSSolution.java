package question104;

import DataStruction.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BFSSolution {
    //时间复杂度：O(n)	层序遍历。
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //层序遍历
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
        }
        return depth;
    }
}
