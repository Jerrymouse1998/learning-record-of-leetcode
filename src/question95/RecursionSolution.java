package question95;

import DataStruction.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecursionSolution {

    public List<TreeNode> generateTrees(int n) {
        if (n==0)return new ArrayList<>();
        return buildBST(1,n);
    }

    private List<TreeNode> buildBST(int start, int end) {
        List<TreeNode> res=new ArrayList<>();
        //区间为空
        if (start > end) {
            res.add(null);
            return res;
        }
        //区间内只有一个数字
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        //区间里有多个数字，每个数字分别作为根节点
        for (int i=start;i<=end;i++){
            //i作为根节点时所有的左子树
            List<TreeNode> leftList=buildBST(start,i-1);
            //i作为根节点时所有的右子树
            List<TreeNode> rightList=buildBST(i+1,end);
            //左右子树两两组合得到树
            for (TreeNode leftTree : leftList) {
                for (TreeNode rightTree : rightList) {
                    //i作为根
                    TreeNode root=new TreeNode(i);
                    root.left=leftTree;
                    root.right=rightTree;
                    //保存
                    res.add(root);
                }
            }
        }
        return res;
    }
}
