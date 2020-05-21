package question188;

public class Solution {
    //时间复杂度：O(n*k)	n 共n天
    //空间复杂度：O(k)
    public int maxProfit(int k, int[] prices) {
        if (k<=0||prices.length<1)return 0;
        //最多只能交易 prices.lenght/2 次
        if (k>prices.length/2) k = prices.length/2;
        //初始化
        int[] dpi0 = new int[k+1];
        int[] dpi1 = new int[k+1];
        for (int j = 1; j < k + 1; j++) {
            dpi1[j] = -prices[0];
        }
        //状态转移
        for (int i = 1; i < prices.length; i++) {
            for (int j = k; j >= 1; j--) {
                //第i天不持股 = Max(第i-1天不持股,第i-1天持股+第i天出售)
                dpi0[j] = Math.max(dpi0[j],dpi1[j]+prices[i]);
                //第i天持股 = Max(第i-1天持股,第i-1天不持股-第i天买入)
                dpi1[j] = Math.max(dpi1[j],dpi0[j-1]-prices[i]);
            }
        }
        return dpi0[k];
    }
}
