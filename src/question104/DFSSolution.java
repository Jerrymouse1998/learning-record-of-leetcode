package question104;

import DataStruction.TreeNode;

public class DFSSolution {
    //时间复杂度：O(n)	像是前序遍历。
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int max1 = 0, max2 = 0;
        //求左子树最深，右子树最深
        max1 += dfs(root.left);
        max2 += dfs(root.right);
        //左右子树最深的加上根的一层深度
        return Math.max(max1, max2) + 1;
    }
}
