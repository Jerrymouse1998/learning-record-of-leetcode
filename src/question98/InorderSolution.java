package question98;

import DataStruction.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderSolution {
    //时间复杂度：O(n)    两次遍历
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //得到中序遍历序列
        inorderTraversal(root, res);
        //检查序列是否严格升序
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1)) return false;
        }
        return true;
    }

    private void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }
}
