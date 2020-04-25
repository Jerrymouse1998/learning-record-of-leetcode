package question123;

public class DPSolution {
    //时间复杂度：O(n)	空间O(n)虽然是三维数组，但2和3是常数。
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        //初始化
        int[][][] dp = new int[prices.length][2][3];
        dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = 0;
        dp[0][1][0] = dp[0][1][1] = dp[0][1][2] = -prices[0];
        //状态转移
        for (int i = 1; i < prices.length; i++) {
            //六种状态
            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] + prices[i]);
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][1] + prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] - prices[i]);
            dp[i][1][2] = dp[i - 1][1][2];
        }
        //最大利润一定是不持股的三种状态之一。
        return Math.max(dp[prices.length - 1][0][2],
                Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][0]));
    }
}
