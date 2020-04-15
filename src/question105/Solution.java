package question105;

import DataStruction.TreeNode;

public class Solution {
    //时间复杂度：O(n)  两个序列遍历一次
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0
                || inorder == null || inorder.length == 0
                || preorder.length != inorder.length) return null;
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        //递归出口
        if (pEnd < pStart || iEnd < iStart) return null;
        //根据前序序列确定根
        TreeNode root = new TreeNode(preorder[pStart]);
        //确定根在中序序列中的位置
        int idx = 0;
        while (inorder[iStart + idx] != preorder[pStart]) idx++;
        //根的左子树和右子树
        root.left = build(preorder, pStart + 1, pStart + idx,
                inorder, iStart, iStart + idx - 1);
        root.right = build(preorder, pStart + idx + 1, pEnd,
                inorder, iStart + idx + 1, iEnd);
        return root;
    }
}
