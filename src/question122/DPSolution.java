package question122;

public class DPSolution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        //初始化
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] -= prices[0];
        //状态转移
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        //最后一天一定是不持股的
        return dp[prices.length - 1][0];
    }
}
