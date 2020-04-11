package question101;

import DataStruction.TreeNode;

public class RecursionSolution {
    //时间复杂度：O(n)    遍历节点
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode root, TreeNode root1) {
        //判断结构是否对称
        if (root == null && root1 == null) return true;
        if (root == null || root1 == null) return false;
        return root.val == root1.val//结构对称，对称节点的值是否相等。
                && isMirror(root.left, root1.right)//左子树和右子树
                && isMirror(root.right, root1.left);//右子树和左子树
    }

}
