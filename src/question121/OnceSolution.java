package question121;

public class OnceSolution {
    //时间复杂度：O(n)
    public int maxProfit(int[] prices) {
        int minPoint=Integer.MAX_VALUE,maxProfit=0;
        for (int i = 0; i < prices.length; i++) {
            //记录曾出现过最低点
            minPoint=Math.min(prices[i],minPoint);
            //当日-曾经的最低
            maxProfit=Math.max(maxProfit,prices[i]-minPoint);
        }
        return maxProfit;
    }
}
