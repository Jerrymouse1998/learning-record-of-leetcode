package question113;

import DataStruction.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class DFSSolution {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new LinkedList<Integer>());
        return res;
    }

    private void dfs(TreeNode root, int sum, LinkedList<Integer> track) {
        if (root == null) return;
        //减去当前节点值，节点加入路径
        sum -= root.val;
        track.add(root.val);
        //如果到达叶子节点并且路径和等于sum
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new LinkedList<>(track));
            track.removeLast();//注意，返回前要removeLast
            return;
        }
        //左右子树
        dfs(root.left, sum, track);
        dfs(root.right, sum, track);
        //回溯
        track.removeLast();
    }
}
