package question226;

import DataStruction.TreeNode;

public class DFSSolution {
    //时间复杂度：O(n)	空间复杂度：O(h)	h 是树高
    public TreeNode invertTree(TreeNode root) {
        //节点为空终止
        if (root ==null) return root;
        //交换根节点的左右子树
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        //分别交换左右子树的左右子树
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
}
