package question98;

import DataStruction.TreeNode;

public class OnceInorderSolution {
    //时间复杂度：O(n)    一次遍历
    TreeNode next = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (next != null && next.val >= root.val) return false;
        next = root;
        return isValidBST(root.right);
    }
}
