package question53;

public class DPSolution {
    //时间复杂度：O(n)
    public int maxSubArray(int[] nums) {
        if (nums==null||nums.length==0)return 0;
        //初始化
        int dp=nums[0];
        //更新当前i结尾的最大序列和同时用max记录最大的序列和
        int max=dp;
        for (int i = 1; i < nums.length; i++) {
            dp=Math.max(nums[i],dp+nums[i]);
            max=Math.max(max,dp);
        }
        return max;
    }
}
