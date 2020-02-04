package question40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BackTrackSolution {

    List<List<Integer>> res=new ArrayList<>();
    int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates==null)return res;
        this.candidates=candidates;
        //排序，将重复元素紧凑在一起
        Arrays.sort(candidates);
        dfs(target,0,new LinkedList<Integer>());
        return res;
    }

    private void dfs(int target, int index, LinkedList<Integer> ans) {
        //说明找到符合要求的路径
        if (target==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i=index;i<candidates.length;i++){
            //本节点和前面的兄弟节点相等,则小剪枝，跳过这条路径
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            //如果减数大于目标值则差为负数，不符合结果，且后续元素都大于目标值，大剪枝，结束后序搜索
            if (target<candidates[i]) {
                break;
            }
            ans.add(candidates[i]);
            //不能重复使用同一元素，所以下次搜索起点从index+1开始
            dfs(target-candidates[i],i+1,ans);
            //每次回溯移除最后一次添加的元素
            ans.removeLast();
        }
    }
}
