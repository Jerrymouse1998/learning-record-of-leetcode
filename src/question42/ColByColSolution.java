package question42;

public class ColByColSolution {
    //时间复杂度：O(n^2)
    public int trap(int[] height) {
        if (height==null||height.length<3)return 0;
        int ans=0;
        for (int col = 0; col < height.length; col++) {
            //找到col左右最高的墙
            int leftMax=0;
            for (int i = col-1; i >=0; i--) leftMax=Math.max(leftMax,height[i]);
            int rightMax=0;
            for (int i = col+1; i < height.length; i++) rightMax=Math.max(rightMax,height[i]);
            //如果最高的墙中最矮的一个大于col的高度，计算当前列上接的水并加入结果
            if (Math.min(leftMax,rightMax)>height[col])ans+=Math.min(leftMax,rightMax)-height[col];
        }
        return ans;
    }
}
