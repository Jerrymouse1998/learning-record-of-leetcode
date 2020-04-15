package question106;

import DataStruction.TreeNode;

public class Solution {
    //时间复杂度：O(n)  两个序列遍历一次
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder==null||inorder.length==0
        ||postorder==null||postorder.length==0
        ||inorder.length!=postorder.length) return null;
        return build(inorder,0,inorder.length-1,
                postorder,0,postorder.length-1);
    }

    private TreeNode build(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        //递归出口
        if (iEnd<iStart||pEnd<pStart)return null;
        //根据后序序列确定根
        TreeNode root=new TreeNode(postorder[pEnd]);
        //找到中序序列中根的位置
        int idx=0;
        while (inorder[iStart+idx]!=postorder[pEnd])idx++;
        //生成根的左右子树
        root.left=build(inorder,iStart,iStart+idx-1,
                postorder,pStart,pStart+idx-1);
        root.right=build(inorder,iStart+idx+1,iEnd,
                postorder,pStart+idx,pEnd-1);
        return root;
    }
}
