package question77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BackTrackSolution {
    //时间复杂度：O(k*(n!/(n-k)!*k!))	k是生成一个组合的时间，共有n!/(n-k)!*k!种组合。
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n==0||k==0)return res;
        dfs(n,k,new LinkedList<Integer>(),1);
        return res;
    }

    private void dfs(int n, int k, LinkedList<Integer> track,int index) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = index; i <= n; i++) {
            track.add(i);
            dfs(n,k,track,i+1);
            track.removeLast();
        }
    }

}
