package question144;

import DataStruction.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterationSolution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                res.add(root.val);//根
                root = root.left;//左
            } else {
                TreeNode pop = stack.pop();
                root = pop.right;//右
            }
        }
        return res;
    }
}
