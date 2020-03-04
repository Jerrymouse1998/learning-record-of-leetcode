package question56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[][] merge(int[][] intervals) {
        List<int[]> res=new ArrayList<>();
        if (intervals==null||intervals.length==0)return res.toArray(new int[0][]);
        //每个区间按照区间左边界升序排序
        Arrays.sort(intervals, (o1,o2)->o1[0]-o2[0]);
        //遍历每个区间
        for (int pre = 0; pre < intervals.length; pre++) {
            //记录当前区间的左右边界值
            int left=intervals[pre][0],right=intervals[pre][1];
            //如果当前区间的右边界大于下一个区间的左边界，即发生重叠
            while (pre<intervals.length-1&&right>=intervals[pre+1][0]){
                right=Math.max(right,intervals[pre+1][1]);
                pre++;
            }
            res.add(new int[]{left,right});
        }
        return res.toArray(new int[0][]);
    }
}
