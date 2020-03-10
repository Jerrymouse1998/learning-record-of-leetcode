package question543;

import DataStruction.TreeNode;

public class DFSSolution {
    //时间复杂度：O(n)
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null)return ans;
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode root) {
        //为空，没有路径
        if (root==null)return 0;
        //深搜
        int leftMax=dfs(root.left);
        int rightMax=dfs(root.right);
        //每个子树根的最大直径
        ans=Math.max(ans,leftMax+rightMax);
        //+1因为子树的根到父节点之间有一条边
        return Math.max(leftMax,rightMax)+1;
    }
}
