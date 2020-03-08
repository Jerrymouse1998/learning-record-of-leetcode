package question322;

import java.util.Arrays;

public class DPSolution {
    //时间复杂度：O(amount*n) n是不同面额硬币的数量
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        //初始化
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        //填写dp
        for (int i = 1; i <= amount; i++) {
            //金额i的所有子问题
            for (int coin : coins) {
                //不存在这个子问题
                if (i-coin<0)continue;
                //在子问题的基础上加一个硬币，取最小值
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
            }
        }
        //检查amount是否有解
        return dp[amount]==amount+1?-1:dp[amount];
    }

}
