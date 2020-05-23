package question198;

public class DPSolution {
    //时间复杂度：O(n)	空间复杂度：O(n)
    //public int rob(int[] nums) {
    //    if (nums.length == 0) return 0;
    //    int[] dp = new int[nums.length + 1];
    //    dp[0] = 0;
    //    dp[1] = nums[0];
    //    for (int i = 2; i < nums.length + 1; i++) {
    //        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
    //    }
    //    return dp[nums.length];
    //}

    //时间复杂度：O(n)	空间复杂度：O(1)
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int pre = 0, cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = temp;
        }
        return cur;
    }
}
