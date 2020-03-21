package question945;

import java.util.Arrays;

public class SortSolution {
    //时间复杂度：O(nlogn)    排序的时间
    public int minIncrementForUnique(int[] A) {
        if (A.length<2)return 0;
        //排序
        Arrays.sort(A);
        int ans=0,curMax=A[0];
        //遍历
        for (int i = 1; i < A.length; i++) {
            //A[i]小于等于curMax,需要增加到大于curMax
            if (A[i]<=curMax){
                ans+=curMax-A[i]+1;
                A[i]=curMax+1;
            }
            //更新curMax
            curMax=Math.max(curMax,A[i]);
        }
        return ans;
    }
}
