package question129;

import DataStruction.TreeNode;

public class DFSSolution {

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    //temp记录路径值
    private void dfs(TreeNode root, int temp) {
        if (root == null) return;
        //到达叶子节点
        if (root.left == null && root.right == null) {
            ans += temp * 10 + root.val;
            return;
        }
        //向左右子树分别深搜
        dfs(root.left, temp * 10 + root.val);
        dfs(root.right, temp * 10 + root.val);
    }
}
