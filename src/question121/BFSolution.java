package question121;

public class BFSolution {
    //时间复杂度：O(n^2)
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                maxProfit=Math.max(maxProfit,prices[j]-prices[i]);
            }
        }
        return maxProfit;
    }
}
