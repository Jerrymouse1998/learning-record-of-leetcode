package question337;

import DataStruction.TreeNode;

public class DPSolution {

    public int rob(TreeNode root) {
        //ans[0]偷根节点,ans[1]不偷根节点
        int[] ans = dp(root);
        return Math.max(ans[0],ans[1]);
    }

    private int[] dp(TreeNode root) {
        int[] ans = new int[2];
        if (root ==null) return ans;
        //左右子树根节点也存在偷和不偷两种情况
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        //偷根节点
        ans[0] = root.val + left[1] + right[1];
        //不偷根节点,左右子树的根节点可偷可不偷,选金额最大即可
        ans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return ans;
    }
}
