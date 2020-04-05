package question145;

import DataStruction.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterationSolution_ReversePreorder {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                res.add(root.val);//根
                root = root.right;//右
            } else {
                TreeNode pop = stack.pop();
                root = pop.left;//左
            }
        }
        //得到根右左的序列，翻转得到后序遍历的左右根
        Stack<Integer> s = new Stack<>();
        for (Integer e : res) s.push(e);
        res.clear();
        while (!s.isEmpty()) res.add(s.pop());
        return res;
    }
}
