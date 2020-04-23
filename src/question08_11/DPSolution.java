package question08_11;

public class DPSolution {
    //时间复杂度：O(n*4) = O(n)
    public int waysToChange(int n) {
        //初始化
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //硬币集
        int[] coins = {1, 5, 10, 25};
        //状态转移
        for (int coin : coins) {
            for (int i = 1; i < n + 1; i++) {
                if (i - coin >= 0) {
                    dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
                }
            }
        }
        return dp[n];
    }
}
