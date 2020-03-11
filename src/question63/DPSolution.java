package question63;

public class DPSolution {
    //时间复杂度：O(m*n)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length,n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        //初始化
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0]==0)dp[i][0]=1;
            else break;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j]==0)dp[0][j]=1;
            else break;
        }
        //状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j]==1)dp[i][j]=0;
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
