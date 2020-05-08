package question572;

import DataStruction.TreeNode;

public class DFSSolution {
    //时间复杂度：O(n*m)	s 的节点数 n， t 的节点数 m。
    //空间复杂度：O(MAX(depth(s),depth(t)))
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        //当前节点为根的子树是否相等
        if (isSame(s, t)) {
            return true;
        } else {
            //深搜
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
