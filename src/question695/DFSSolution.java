package question695;

public class DFSSolution {
    //时间复杂度：O(m*n)
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        //遍历
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //是陆地
                if (grid[i][j]==1){
                    //深搜并更新max
                    max=Math.max(max,dfs(grid,i,j));
                }
            }
        }
        return max;
    }
    //深搜
    private int dfs(int[][] grid, int i, int j) {
        //越界都是海水
        if (i<0||i==grid.length||j<0||j==grid[i].length){
            return 0;
        }
        if (grid[i][j]==1){
            grid[i][j]=0;//沉岛
            //上下左右四个方向深搜，别忘了开始的一块陆地
            return 1+dfs(grid,i+1,j)+dfs(grid,i-1,j)+dfs(grid,i,j+1)+dfs(grid,i,j-1);
        }
        return 0;
    }
}
