package question46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BackTrackSolution {

    List<List<Integer>> res=new ArrayList<>();
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        if (nums==null||nums.length==0)return res;
        this.nums=nums;
        //标记每个元素是否被使用过，默认值false表示未使用
        boolean[] flag=new boolean[nums.length];
        dfs(new LinkedList<Integer>(),flag);
        return res;
    }
    //深度优先遍历
    private void dfs(LinkedList<Integer> combination,boolean[] flag) {
        //完成组合
        if (combination.size()==nums.length){
            res.add(new ArrayList<>(combination));
            return;
        }
        for (int i=0;i<nums.length;i++){
            //当前元素未使用过，防止一条路径上出现一个元素被重复使用
            if (!flag[i]){
                //将当前元素加入组合中，并将元素对应的标志置为true
                combination.add(nums[i]);
                flag[i]=!flag[i];
                dfs(combination,flag);
                //每次回溯将最后加入的元素移除，并将被移除元素对应的标志置为false
                flag[i]=!flag[i];
                combination.removeLast();
            }
        }
    }
}
