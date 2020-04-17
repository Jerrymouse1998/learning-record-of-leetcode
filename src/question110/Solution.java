package question110;

import DataStruction.TreeNode;

public class Solution {
    // 时间复杂度：O(n) 	深度优先遍历一次
    boolean isBBT = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBBT;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        //左右子树深度
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;
        //高度不平衡，false
        if (Math.abs(left - right) > 1) isBBT = false;
        //左右子树最大深度
        return Math.max(left, right);
    }
}
