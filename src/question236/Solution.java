package question236;

import DataStruction.TreeNode;

public class Solution {
    //时间复杂度：O(n)	深度遍历
    //空间复杂度：O(n)	递归栈大小取决于树的深度，最坏情况树呈链表状
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base 子树中不存在 p 和 q ,或者子树中找到了 p 或 q
        if (root == null||root == p||root==q)return root;
        //到左右子树中寻找 p 或 q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //一边为空不存在 p 或 q,公共祖先一定是另一边标记的节点
        if (left==null)return right;
        if (right ==null)return left;
        //p 和 q 分别在子树根 root 的两侧各一个
        return root;
    }
}
