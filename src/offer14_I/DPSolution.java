package offer14_I;

public class DPSolution {
    //时间复杂度：O(n^2)  空间复杂度：O(n)
    //public int cuttingRope(int n) {
    //    int[] dp = new int[n + 1];
    //    //初始化
    //    dp[1]=dp[2]=1;
    //    //[3,n] 种不通长度的绳子
    //    for (int i = 3; i < n + 1; i++) {
    //        //每个绳子有 [0,i) 个可剪断的位置
    //        for (int j = 0; j < i; j++) {
    //            dp[i] = Math.max(dp[i],Math.max((i-j)*j,j*dp[i-j]));
    //        }
    //    }
    //    return dp[n];
    //}

    //时间复杂度：O(n)  空间复杂度：O(n)
    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(2 * dp[i - 2], 3 * dp[i - 3]);
        }
        return dp[n];
    }

}
