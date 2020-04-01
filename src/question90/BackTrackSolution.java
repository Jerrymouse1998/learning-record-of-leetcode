package question90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BackTrackSolution {
    //时间复杂度：O(n*2^n)	n数组元素个数。生成每个子集最多需要n的时间，共有2^n个子集。
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums==null||nums.length==0)return res;
        //把重复的元素紧凑到一起
        Arrays.sort(nums);
        dfs(nums,0,new LinkedList<Integer>());
        return res;
    }

    private void dfs(int[] nums, int idx, LinkedList<Integer> track) {
        res.add(new ArrayList<>(track));
        for (int i = idx; i < nums.length; i++) {
            //重复的剪枝
            if (i>idx&&nums[i]==nums[i-1])continue;
            track.add(nums[i]);
            dfs(nums,i+1,track);
            track.removeLast();
        }
    }
}
