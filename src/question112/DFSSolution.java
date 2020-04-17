package question112;

import DataStruction.TreeNode;

public class DFSSolution {
    // 时间复杂度：O(n) 	深度优先遍历一次
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        //到达叶子节点，返回路径和是否等于0
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        //左右子树是否存在符合要求的路径
        boolean left = dfs(root.left, sum);
        boolean right = dfs(root.right, sum);
        return left || right;
    }
}
