package question42;

public class DoublePointerSolution {
    //时间复杂度：O(n)
    public int trap(int[] height) {
        if (height==null||height.length<3)return 0;
        int leftMax=0,rightMax=0,ans=0,left=1,right=height.length-2;
        while (left<=right){
            //计算更新leftMax rightMax
            leftMax=Math.max(leftMax,height[left-1]);
            rightMax=Math.max(rightMax,height[right+1]);
            //比较leftMax和rightMax，找到较低的那一侧
            if (leftMax<rightMax){
                if (leftMax>height[left])ans+=leftMax-height[left];
                left++;
            }else {
                if (rightMax>height[right])ans+=rightMax-height[right];
                right--;
            }
        }
        return ans;
    }
}
