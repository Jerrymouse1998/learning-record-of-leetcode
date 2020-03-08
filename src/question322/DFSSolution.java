package question322;

public class DFSSolution {
    //时间复杂度：O(amount^n) n是不同面额硬币的数量
    int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (coins==null||coins.length==0)return -1;
        dfs(coins,amount,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    //深搜，count记录硬币数量
    private void dfs(int[] coins, int amount, int count) {
        //如果小于0，说明当前组合不对，回溯
        if (amount<0){
            return;
        }
        //等于0说明当前组合正确，如果硬币数量更少，则更新结果
        if (amount==0){
            ans=Math.min(ans,count);
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            dfs(coins,amount-coins[i],count+1);
        }
    }
}
