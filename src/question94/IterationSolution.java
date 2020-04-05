package question94;

import DataStruction.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterationSolution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        //当栈不为空，或者节点不为空，就继续遍历
        while (!stack.isEmpty() || root != null) {
            if (root != null) {//节点不为空，入栈，向左节点深搜
                stack.add(root);
                root = root.left;//左
            } else {//左节点为空，即深搜触底。出栈一个元素
                TreeNode pop = stack.pop();
                res.add(pop.val);//根
                root = pop.right;//右
            }
        }
        return res;
    }
}
