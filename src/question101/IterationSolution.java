package question101;

import DataStruction.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class IterationSolution {
    //时间复杂度：O(n)    遍历节点
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode r1 = queue.poll();
            TreeNode r2 = queue.poll();
            if (r1 == null && r2 == null) continue;//结构一样
            if (r1 == null || r2 == null) return false;//结构不同
            if (r1.val != r2.val) return false;//对称节点值不同
            //将镜像节点入队
            queue.add(r1.left);
            queue.add(r2.right);
            queue.add(r1.right);
            queue.add(r2.left);
        }
        return true;
    }
}
