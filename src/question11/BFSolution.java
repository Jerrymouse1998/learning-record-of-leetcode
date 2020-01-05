package question11;

public class BFSolution {

    public int maxArea(int[] height) {
        int maxarea=0;
        for (int i=0;i<height.length;i++){
            for (int j=i+1;j<height.length;j++)
//                (j-i)一定要记得加括号。。。不要做蠢事
                maxarea=Math.max(maxarea,Math.min(height[i],height[j])*(j-i));
        }
        return maxarea;
    }
}
