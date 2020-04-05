package question145;

import DataStruction.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecursionSolution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);//左
        dfs(root.right);//右
        res.add(root.val);//根
    }
}
