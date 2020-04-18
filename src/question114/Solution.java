package question114;

import DataStruction.TreeNode;

public class Solution {
    //时间复杂度：O(n)	最坏情况二叉树初始就是链表形式，但是全部都是靠左，curr需要遍历每个节点。
    public void flatten(TreeNode root) {
        TreeNode curr=root;
        while (curr != null) {
            //找到左子树不为空的节点
            if (curr.left != null) {
                //p指向左子树的最右节点
                TreeNode p = curr.left;
                while(p.right!=null)p=p.right;
                //把curr的左子树移动到curr的右子树
                p.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            //移动curr
            curr=curr.right;
        }
    }
}
