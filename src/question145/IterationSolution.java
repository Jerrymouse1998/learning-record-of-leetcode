package question145;

import DataStruction.TreeNode;

import java.util.*;

public class IterationSolution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        //用set记录访问过的节点
        Set<TreeNode> set = new HashSet<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || root != null) {
            //节点不为空且没有被访问过，入栈
            while (cur != null && !set.contains(cur)) {
                stack.push(cur);
                cur = cur.left;//左
            }
            //遍历完左子树,peek根节点
            cur = stack.peek();
            //如果cur的右子树为空，或者第二次访问节点
            if (cur.right == null || set.contains(cur)) {
                //记录根节点，并弹出
                res.add(cur.val);
                set.add(cur);
                stack.pop();
                //如果栈不空，继续检查遍历下一个栈顶元素的右子树
                if (stack.isEmpty()) return res;
                cur = stack.peek().right;
            } else {//右子树不为空并且第一次访问,遍历右子树
                set.add(cur);
                cur = cur.right;//右
            }
        }
        return res;
    }
}
