package question226;

import DataStruction.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BFSSolution {
    //时间复杂度：O(n)	空间复杂度：O(n)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            //交换左右子树
            TreeNode temp = poll.right;
            poll.right = poll.left;
            poll.left = temp;
            //左右子树不空，则入队
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }
        return root;
    }
}
