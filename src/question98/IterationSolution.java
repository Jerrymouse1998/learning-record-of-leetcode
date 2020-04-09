package question98;

import DataStruction.TreeNode;

import java.util.Stack;

public class IterationSolution {

    public boolean isValidBST(TreeNode root) {
        if (root==null)return true;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode next=null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if (next!=null&&next.val>=root.val)return false;
            next=root;
            root=root.right;
        }
        return true;
    }
}
