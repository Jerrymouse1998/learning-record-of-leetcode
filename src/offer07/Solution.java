package offer07;

import DataStruction.TreeNode;

import java.util.HashMap;

public class Solution {
    //时间复杂度：O(n)    空间复杂度：O(n)
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart > pend || istart > iend) return null;
        if (pstart == pend) return new TreeNode(preorder[pstart]);
        TreeNode root = new TreeNode(preorder[pstart]);
        int rootIdx = map.get(preorder[pstart]);
        int leftOffset = rootIdx - istart, rightOffset = iend - rootIdx;
        root.left = build(preorder, pstart + 1, pstart + leftOffset, inorder, istart, rootIdx - 1);
        root.right = build(preorder, pend - rightOffset + 1, pend, inorder, rootIdx + 1, iend);
        return root;
    }
}
