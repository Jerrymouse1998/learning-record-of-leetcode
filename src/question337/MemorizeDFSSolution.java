package question337;

import DataStruction.TreeNode;

import java.util.HashMap;

public class MemorizeDFSSolution {

    HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int ans = root.val;
        if (root.left != null) {
            ans += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            ans += rob(root.right.left) + rob(root.right.right);
        }
        ans = Math.max(ans, rob(root.left) + rob(root.right));
        map.put(root, ans);
        return ans;
    }
}
