package question42;

public class RowByRowSolution {
    //时间复杂度：O(maxHeight*n)
    public int trap(int[] height) {
        if (height==null||height.length<3)return 0;
        int ans=0,maxHeight=height[0];
        for (int h : height)if (h>maxHeight)maxHeight=h;
        for (int row = 1; row <= maxHeight; row++) {
            int temp=0;
            //是否开始统计temp
            boolean isStart=false;
            for (int i = 0; i < height.length; i++) {
                if (isStart&&height[i]<row)temp++;
                if (height[i]>=row){
                    ans+=temp;
                    temp=0;
                    isStart=true;
                }
            }
        }
        return ans;
    }
}
