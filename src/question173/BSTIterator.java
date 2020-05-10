package question173;

import DataStruction.TreeNode;

import java.util.Stack;

/**
 * 时间复杂度：O(1)	hasNext() 毋庸置疑的是个 O(1) 操作；
 * next() 操作虽然有一个最坏情况(呈链表)下 O(n)的操作，但是每个节点只会入栈一次，
 * 所以 n 次 next() 操作平均下来时间复杂度依然是 O(1) ，这是一种"摊还"的概念。
 *
 * 空间复杂度：O(h)	h 树的高度
 */
public class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        this.inorder_left(root);
    }

    //遍历 root 最左节点入栈
    private void inorder_left(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            inorder_left(node.right);
        }
        return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
