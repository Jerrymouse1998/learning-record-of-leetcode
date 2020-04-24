package question122;

public class GreedySolution {
    //时间复杂度：O(n)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int Profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            //今天i买，明天i+1赚钱。就今天买入，明天卖。
            int sub = prices[i + 1] - prices[i];
            if (sub > 0) {
                Profit += sub;
            }
        }
        return Profit;
    }
}
