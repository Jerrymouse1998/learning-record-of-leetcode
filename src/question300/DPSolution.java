package question300;

import java.util.Arrays;

public class DPSolution {
    //时间复杂度：O(n^2)
    public int lengthOfLIS(int[] nums) {
        if (nums==null||nums.length==0)return 0;
        int[] dp=new int[nums.length];
        int maxLen=0;
        //初始化
        Arrays.fill(dp,1);
        //状态转移
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //如果i元素>j元素，则i可以接在j元素后面作为上升子序列
                if (nums[i]>nums[j])dp[i]=Math.max(dp[i],dp[j]+1);
            }
            //更新最大长度
            maxLen=Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}
