package question70;

public class DPSolution {
    //时间复杂度：O(n)
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0]=dp[1]=1;
        for (int i = 2; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
