package question62;

public class DPSolution {
    //时间复杂度：O(m*n)
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        //初始化
        for (int i = 0; i < m; i++) dp[i][0]=1;
        for (int j = 0; j < n; j++) dp[0][j]=1;
        //状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
