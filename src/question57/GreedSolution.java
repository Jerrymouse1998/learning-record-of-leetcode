package question57;

import java.util.ArrayList;
import java.util.List;

public class GreedSolution {
    //时间复杂度：O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        int index=0,n=intervals.length;
        //找到新区间的放置位置，最后一个右边界小于新区间左边界的旧区间的后面
        while (index<n&&newInterval[0]>intervals[index][1]){
            res.add(intervals[index++]);
        }
        //temp记录合并后新区间的左右边界值
        int temp[]=new int[]{newInterval[0],newInterval[1]};
        while (index<n&&newInterval[1]>=intervals[index][0]){
            temp[0]=Math.min(temp[0],intervals[index][0]);
            temp[1]=Math.max(temp[1],intervals[index][1]);
            index++;
        }
        //将合并后的新区间放入结果集
        res.add(temp);
        //将剩余区间放入结果集
        while (index<n){
            res.add(intervals[index++]);
        }
        return res.toArray(new int[0][]);
    }
}
