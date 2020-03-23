package question17_16;

public class DPSolution {
    //时间复杂度：O(n)
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        //初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //状态转移
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    //只需要用两个记录dp[i-1]和dp[i-2]的值就可以了，可以将时间复杂度降低到O(1)。
    //public int massage(int[] nums) {
    //    if (nums==null||nums.length==0)return 0;
    //    if (nums.length==1)return nums[0];
    //    //记录前一个dp值和前前一个dp值
    //    int prepredp=0,predp=0;
    //    //状态转移
    //    for (int i = 0; i < nums.length; i++) {
    //        int currdp=Math.max(predp,prepredp+nums[i]);
    //        prepredp=predp;
    //        predp=currdp;
    //    }
    //    return predp;
    //}
}
