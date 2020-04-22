package question199;

import DataStruction.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class DFSSolution {
    //时间复杂度：O(n)
    List<Integer> res = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        //因为每层只会保存第一个访问到的节点。
        //所以size=depth，说明当前层第一次访问。root一定是本层最右节点。
        if (res.size() == depth) res.add(root.val);
        //右>左
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }
}
