package question11;

public class DoublePointerSolution {
    public int maxArea(int[] height) {
        int maxarea=0,l=0,r=height.length-1;
        while (l<r){
            maxarea=Math.max(maxarea,Math.min(height[l],height[r])*(r-l));
            if (height[l]<height[r]){
                l++;
            }else {
                r--;
            }
        }
        return maxarea;
    }
}
