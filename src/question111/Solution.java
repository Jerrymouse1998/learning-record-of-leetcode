package question111;

import DataStruction.TreeNode;

public class Solution {
    // 时间复杂度：O(n) 	深度优先遍历一次
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        //左右子树的深度
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //左右子树都为空，找到叶子节点，返回根节点1
        //如果有一边为空，则返回非空一侧的深度+根节点
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        //最后计算深度最小的一侧+根节点
        return Math.min(left, right) + 1;
    }
}
