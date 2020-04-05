package question144;

import DataStruction.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecursionSolution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return res;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        res.add(root.val);//根
        dfs(root.left);//左
        dfs(root.right);//右
    }
}
