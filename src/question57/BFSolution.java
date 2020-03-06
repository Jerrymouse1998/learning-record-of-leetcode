package question57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BFSolution {
    //时间复杂度：O(nlogn)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] input=new int[n+1][2];
        //将newInterval和Intervals都输入一个数组
        for (int i = 0; i < n; i++) {
            input[i][0]=intervals[i][0];
            input[i][1]=intervals[i][1];
        }
        input[n][0]=newInterval[0];
        input[n][1]=newInterval[1];
        //合并区间
        return merger(input);
    }

    private int[][] merger(int[][] intervals) {
        List<int[]> res=new ArrayList<>();
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        for (int i = 0; i < intervals.length; i++) {
            int left=intervals[i][0],right=intervals[i][1];
            while (i<intervals.length-1&&right>=intervals[i+1][0]){
                right=Math.max(right,intervals[i+1][1]);
                i++;
            }
            res.add(new int[]{left,right});
        }
        return res.toArray(new int[0][]);
    }
}
