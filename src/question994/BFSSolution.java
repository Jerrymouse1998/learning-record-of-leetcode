package question994;

import java.util.LinkedList;
import java.util.Queue;

public class BFSSolution {

    public int orangesRotting(int[][] grid) {
        int row = grid.length,col=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        //遍历，统计新鲜橘子，坏橘子坐标入队
        int count=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]==1)count++;
                else if (grid[i][j]==2)queue.add(new int[]{i,j});
            }
        }
        //round传染的轮次
        int round=0;
        //当队列不空并且还存在好橘子就广搜BFS
        while (count>0&&!queue.isEmpty()){
            round++;
            //n记录当前坏橘子数量，防止出队入队导致不同轮次之间混乱
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] rc = queue.poll();
                int r=rc[0],c=rc[1];
                //每个出队的坏橘子的四个正方向上邻接节点是否是好橘子，如果是就传染腐烂并入队
                if (r-1>=0&&grid[r-1][c]==1){
                    grid[r-1][c]=2;
                    count--;
                    queue.add(new int[]{r-1,c});
                }
                if (r+1<row&&grid[r+1][c]==1){
                    grid[r+1][c]=2;
                    count--;
                    queue.add(new int[]{r+1,c});
                }
                if (c-1>=0&&grid[r][c-1]==1){
                    grid[r][c-1]=2;
                    count--;
                    queue.add(new int[]{r,c-1});
                }
                if (c+1<col&&grid[r][c+1]==1){
                    grid[r][c+1]=2;
                    count--;
                    queue.add(new int[]{r,c+1});
                }
            }
        }
        if (count>0)return -1;
        else return round;
    }
}
