package question124;

import DataStruction.TreeNode;

public class DFSSolution {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        //求左右子树的路径和
        int left = dfs(root.left);
        int right = dfs(root.right);
        //如果路径和是负数，则舍弃掉这条路径
        if (left < 0) {
            left = 0;
        }
        if (right < 0) {
            right = 0;
        }
        //更新max
        max = Math.max(max, left + right + root.val);
        //返回子树最大的路径和
        return Math.max(left, right) + root.val;
    }
}
