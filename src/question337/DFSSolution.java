package question337;

import DataStruction.TreeNode;

public class DFSSolution {

    public int rob(TreeNode root) {
        if (root == null) return 0;
        //偷根节点
        int ans = root.val;
        //再跳过根节点的左右孩子，分别去偷左右孩子的孙子节点
        if (root.left != null) {
            ans += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            ans += rob(root.right.left) + rob(root.right.right);
        }
        //Max(偷根节点的情况,不偷根节点的情况)
        return Math.max(ans, rob(root.left) + rob(root.right));
    }
}
