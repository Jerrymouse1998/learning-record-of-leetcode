package question39;

import java.util.*;

public class BackTrackSolution {

    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates==null)return res;
        dfs(target,0,new Stack<Integer>(),candidates);
        return res;
    }
    //深度遍历
    private void dfs(int target, int index, Stack<Integer> pre, int[] candidates) {
        //等于零说明结果符合要求
        if (target==0){
            res.add(new ArrayList<>(pre));
            return;
        }
        //遍历，index为本分支上一节点的减数的下标
        for (int i=index;i<candidates.length;i++){
            //如果减数大于目标值，则差为负数，不符合结果
            if (candidates[i]<=target){
                pre.push(candidates[i]);
                //目标值减去元素值
                dfs(target-candidates[i],i,pre, candidates);
                //每次回溯将最后一次加入的元素删除
                pre.pop();
            }
        }
    }
}
