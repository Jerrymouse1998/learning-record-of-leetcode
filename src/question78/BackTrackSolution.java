package question78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BackTrackSolution {

    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums==null||nums.length<0)return res;
        dfs(nums,0,new LinkedList<Integer>());
        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> track) {
        res.add(new ArrayList<>(track));
        for (int i = index; i < nums.length; i++) {
            track.add(nums[i]);
            dfs(nums,i+1,track);
            track.removeLast();
        }
    }
}
