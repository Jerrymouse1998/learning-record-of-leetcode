package question99;

import DataStruction.TreeNode;

import java.util.Stack;

public class IterationInorderSolution {
    //时间复杂度：O(n)    空间复杂度：O(n)
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode first = null;//记录第一个需要交换的节点
        TreeNode second = null;//记录第二个需要交换的节点
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);//当前遍历节点的前一个节点
        //中序遍历找到两个节点
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (first == null && pre.val > root.val) first = pre;
            if (first != null && pre.val > root.val) second = root;
            pre = root;
            root = root.right;
        }
        //交换节点值
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
