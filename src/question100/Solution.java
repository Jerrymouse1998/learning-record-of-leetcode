package question100;

import DataStruction.TreeNode;

public class Solution {
    //时间复杂度：O(n)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //结构上
        if (p==null&&q==null)return true;
        if (p==null||q==null)return false;
        //数值上不等则false，相等则继续判断其他节点的数值
        if (p.val!=q.val)return false;
        return isSameTree(p.left,q.left)&&
                isSameTree(p.right,q.right);
    }
}
