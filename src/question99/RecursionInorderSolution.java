package question99;

import DataStruction.TreeNode;

public class RecursionInorderSolution {
    //时间复杂度：O(n)    空间复杂度：O(n)
    TreeNode first;//记录第一个需要交换的节点
    TreeNode second;//记录第二个需要交换的节点
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);//当前遍历节点的前一个节点

    public void recoverTree(TreeNode root) {
        //中序遍历找到两个节点
        inorderTraversal(root);
        //交换两个节点的值
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        //第一个节点是，大于后一个节点的节点
        if (first == null && pre.val > root.val) first = pre;
        //第二个节点是在第一个节点之后，小于前一个节点的节点
        if (first != null && pre.val > root.val) second = root;
        pre = root;
        inorderTraversal(root.right);
    }
}
