package question695;

import java.util.LinkedList;
import java.util.Queue;

public class BFSSolution {
    //时间复杂度：O(m*n)
    boolean[][] used;
    int m;
    int n;
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        this.m=grid.length;
        this.n=grid[0].length;
        this.used=new boolean[m][n];
        //遍历每个位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果是陆地且没用过
                if (grid[i][j]==1&&!used[i][j]){
                    //广搜更新最大岛屿面积
                    max=Math.max(max,bfs(grid,i,j));
                }
            }
        }
        return max;
    }
    //广搜
    private int bfs(int[][] grid, int i, int j) {
        //广搜队列
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{i,j});//当前陆地入队
        used[i][j]=true;//更新标记数组
        int res=1;//开始就是一块陆地
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r=curr[0],c=curr[1];
            //判断当前出队陆地的上下左右是否是陆地且没使用过
            if (r-1>=0&&grid[r-1][c]==1&&!used[r-1][c]){
                queue.add(new int[]{r-1,c});
                used[r-1][c]=true;
                res++;
            }
            if (c-1>=0&&grid[r][c-1]==1&&!used[r][c-1]){
                queue.add(new int[]{r,c-1});
                used[r][c-1]=true;
                res++;
            }
            if (r+1<m&&grid[r+1][c]==1&&!used[r+1][c]){
                queue.add(new int[]{r+1,c});
                used[r+1][c]=true;
                res++;
            }
            if (c+1<n&&grid[r][c+1]==1&&!used[r][c+1]){
                queue.add(new int[]{r,c+1});
                used[r][c+1]=true;
                res++;
            }
        }
        return res;
    }
}
