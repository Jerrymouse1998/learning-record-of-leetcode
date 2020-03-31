package question912;

import DataStruction.TreeNode;

public class BinarySearchTreeSort {
    /*
        二叉搜索/排序树排序
        平均/最好时间复杂度：O(nlogn)
        最坏时间复杂度：O(n^2)
        空间复杂度：O(n)
        稳定
     */
    public int[] sortArray(int[] nums) {
        //构建根节点
        TreeNode root = new TreeNode(nums[0]);
        //构建二叉搜索树
        for (int i = 1; i < nums.length; i++) {
            buildBST(root, nums[i]);
        }
        //中序遍历,保存到nums中
        //这里必须是传一个引用，不能是普通类型的int。
        //不然在触底返回的时候因为的作用域的问题，普通类型int的变量值不能继续正确递增。
        inorderTraversal(root, nums, new int[1]);
        return nums;
    }

    private void inorderTraversal(TreeNode root, int[] nums, int[] idx) {
        if (root == null) return;
        inorderTraversal(root.left, nums, idx);
        nums[idx[0]++] = root.val;
        inorderTraversal(root.right, nums, idx);
    }

    private void buildBST(TreeNode root, int num) {
        if (root == null) return;
        if (num >= root.val) {//大于父节点插入右子树
            if (root.right == null) {
                root.right = new TreeNode(num);
            } else {
                buildBST(root.right, num);
            }
        } else {//小于父节点插入左子树
            if (root.left == null) {
                root.left = new TreeNode(num);
            } else {
                buildBST(root.left, num);
            }
        }
    }
}
