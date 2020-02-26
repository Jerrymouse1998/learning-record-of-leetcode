package question42;


public class DPSolution {
    //时间复杂度：O(n)
    public int trap(int[] height) {
        if (height==null||height.length<3)return 0;
        //计算leftMax，rightMax
        int[] leftMax=new int[height.length],rightMax=new int[height.length];
        for (int i = 1; i < height.length; i++) leftMax[i]=Math.max(leftMax[i-1],height[i-1]);
        for (int i=height.length-2;i>=0;i--) rightMax[i]=Math.max(rightMax[i+1],height[i+1]);
        //计算每一列上的水
        int ans=0;
        for (int i = 1; i < height.length-1; i++) {
            int min=Math.min(leftMax[i],rightMax[i]);
            if (min>height[i]){
                ans+=min-height[i];
            }
        }
        return ans;
    }
}
