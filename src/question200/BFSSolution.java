package question200;

import java.util.LinkedList;
import java.util.Queue;

public class BFSSolution {
    //时间复杂度：O(n)	最坏情况两次遍历，主方法中找陆地遍历一次，广搜遍历一次。
    int count = 0;//计数器
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return count;
        //遍历
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //找到陆地就将计数器+1，并将当前陆地所属岛屿上的所有陆地全部置为0
                if (grid[i][j] == '1') {
                    //广搜
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                //四个方向搜索，是陆地就置为0
                for (int l = 0; l < 4; l++) {
                    int diri = poll[0] + directions[l][0];
                    int dirj = poll[1] + directions[l][1];
                    if (diri>=0&&diri<grid.length&&
                            dirj>=0&&dirj<grid[0].length&&
                            grid[diri][dirj] == '1') {
                        grid[diri][dirj] = '0';
                        queue.add(new int[]{diri, dirj});
                    }
                }
            }
        }
    }
}
