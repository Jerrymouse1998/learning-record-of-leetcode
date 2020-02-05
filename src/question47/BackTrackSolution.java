package question47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BackTrackSolution {

    List<List<Integer>> res=new ArrayList<>();
    int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums==null||nums.length==0)return res;
        this.nums=nums;
        //对数组排序，使重复元素紧凑在一起，方便后续剪枝
        Arrays.sort(nums);
        //标记每个元素的使用情况，默认值false表示未使用
        boolean[] flag=new boolean[nums.length];
        dfs(flag,new LinkedList<Integer>());
        return res;
    }

    private void dfs(boolean[] flag, LinkedList<Integer> track) {
        //完成组合
        if (track.size()==nums.length){
            res.add(new ArrayList<>(new ArrayList<>(track)));
            return;
        }
        for (int i=0;i<nums.length;i++){
            //当前元素未被使用，防止一条路径上出现一个元素被重复使用
            if (!flag[i]){
                //当前元素和之前一个兄弟节点使用的元素相等，且相等元素节点不是当前节点的父节点
                if (i>0&&nums[i]==nums[i-1]&&!flag[i-1])continue;
                //将当前元素加入组合中，并将元素对应的标志置为true
                track.add(nums[i]);
                flag[i]=true;
                dfs(flag,track);
                //每次回溯将最后加入的元素移除，并将被移除元素对应的标志置为false
                track.removeLast();
                flag[i]=false;
            }
        }
    }
}
