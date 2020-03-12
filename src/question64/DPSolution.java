package question64;

public class DPSolution {
    //时间复杂度：O(row*col)
    public int minPathSum(int[][] grid) {
        int row = grid.length,col=grid[0].length;
        int[][] dp=new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //第一行
                if (i==0&&j!=0)dp[i][j]=dp[i][j-1]+grid[i][j];
                    //第一列
                else if (j==0&&i!=0)dp[i][j]=dp[i-1][j]+grid[i][j];
                    //中间部分
                else if (j!=0&&i!=0)dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                    //第一个元素[0][0]
                else dp[i][j]=grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    /*  优化空间复杂度到O(1)，直接在grid数组自身每个位置记录对应的最小路径和。
        public int minPathSum(int[][] grid) {
        int row = grid.length,col=grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //第一行
                if (i==0&&j!=0)grid[i][j]=grid[i][j-1]+grid[i][j];
                //第一列
                else if (j==0&&i!=0)grid[i][j]=grid[i-1][j]+grid[i][j];
                //中间部分
                else if (j!=0&&i!=0)grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
                //第一个元素[0][0]
                else grid[i][j]=grid[i][j];
            }
        }
        return grid[row-1][col-1];
        }
     */
}
