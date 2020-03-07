package question59;

public class Solution {
    //时间复杂度：O(n^2)
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int num=1,t=0,r=n-1,b=n-1,l=0;
        while (num<=n*n){
            //从左到右
            for (int i = l; i <= r; i++) res[t][i]=num++;
            t++;
            //从上到下
            for (int i = t; i <= b; i++) res[i][r]=num++;
            r--;
            //从右到左
            for (int i = r; i >= l; i--) res[b][i]=num++;
            b--;
            //从下到上
            for (int i = b; i >= t; i--) res[i][l]=num++;
            l++;
        }
        return res;
    }
}
