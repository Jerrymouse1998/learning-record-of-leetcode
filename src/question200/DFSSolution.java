package question200;

public class DFSSolution {
    //时间复杂度：O(n)	最坏情况两次遍历
    int count = 0;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return count;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            int diri = i + directions[k][0];
            int dirj = j + directions[k][1];
            if (diri >= 0 && diri < grid.length &&
                    dirj >= 0 && dirj < grid[0].length &&
                    grid[diri][dirj] == '1') {
                dfs(grid, diri, dirj);
            }
        }
    }
}
