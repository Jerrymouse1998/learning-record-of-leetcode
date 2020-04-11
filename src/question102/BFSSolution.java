package question102;

import DataStruction.TreeNode;

import java.util.*;

public class BFSSolution {
    //时间复杂度：O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null)return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        //层序遍历
        while (!queue.isEmpty()) {
            //记录一层的数值
            List<Integer> round=new ArrayList<>();
            int size = queue.size();
            //弹出一层节点
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                round.add(p.val);
                if (p.left!=null)queue.add(p.left);
                if (p.right!=null)queue.add(p.right);
            }
            res.add(round);
        }
        return res;
    }
}
