package question84;

public class BFSolution {

    public int largestRectangleArea(int[] heights) {
        if (heights==null||heights.length==0)return 0;
        int ans=0;
        //遍历
        for (int i = 0; i < heights.length; i++) {
            //找左边最后一个大于小于当前高度的位置
            int left=i;
            while (left>0&&heights[left-1]>=heights[i]){
                left--;
            }
            //找右边最后一个大于小于当前高度的位置
            int right=i;
            while (right<heights.length-1&&heights[right+1]>=heights[i]){
                right++;
            }
            //计算以当前元素作为高形成的矩形的面积
            ans=Math.max(ans,heights[i]*(right-left+1));
        }
        return ans;
    }
}
