package question96;

public class DPSolution {
    //时间复杂度：O(n^2)
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=dp[1]=1;
        //状态转移
        for (int i = 2; i < n + 1; i++) {
            //[1,i]中的i个数字分别做为根节点
            for (int j = 1; j < i+1; j++) {
                //左子树*右子树
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
