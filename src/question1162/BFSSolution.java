package question1162;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFSSolution {

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue=new ArrayDeque<>();
        //遍历将所有陆地的坐标入队
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i,j});
                }
            }
        }
        //全是陆地或者全是海洋返回-1
        if (queue.size() == n * n || queue.isEmpty()) {
            return -1;
        }
        //BFS记录一下最后是第几层
        int round=-1;
        while (!queue.isEmpty()) {
            round++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                //向下
                if (temp[0] + 1 < n && grid[temp[0] + 1][temp[1]] == 0) {
                    grid[temp[0] + 1][temp[1]] = 1;//标记已入队
                    queue.add(new int[]{temp[0] + 1, temp[1]});
                }
                //向右
                if (temp[1] + 1 < n && grid[temp[0]][temp[1]+1] == 0) {
                    grid[temp[0]][temp[1]+1]=1;
                    queue.add(new int[]{temp[0],temp[1]+1});
                }
                //向上
                if (temp[0] - 1 >= 0 && grid[temp[0]-1][temp[1]] == 0) {
                    grid[temp[0]-1][temp[1]] =1;
                    queue.add(new int[]{temp[0]-1,temp[1]});
                }
                //向左
                if (temp[1] - 1 >= 0 && grid[temp[0]][temp[1]-1] == 0) {
                    grid[temp[0]][temp[1]-1]=1;
                    queue.add(new int[]{temp[0],temp[1]-1});
                }
            }
        }
        return round;
    }
}
