package question108;

import DataStruction.TreeNode;

public class Solution {
    //时间复杂度：O(n) 	每个元素访问一次。
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        //出口
        if (end < start) {
            return null;
        }
        int mid = (start + end) >>> 1;
        //中间元素作为根
        TreeNode root = new TreeNode(nums[mid]);
        //生成左右子树
        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);
        return root;
    }
}
