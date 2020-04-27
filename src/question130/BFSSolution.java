package question130;

import java.util.LinkedList;
import java.util.Queue;

public class BFSSolution {
    //时间复杂度：O(n) 空间复杂度：O(n)

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int r, c;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        this.r = board.length;
        this.c = board[0].length;
        //第一列，最后一列
        for (int i = 0; i < r; i++) {
            if (board[i][0] == 'O') bfs(i, 0, board);
            if (board[i][c - 1] == 'O') bfs(i, c - 1, board);
        }
        //第一行、最后一行
        for (int j = 0; j < c; j++) {
            if (board[0][j] == 'O') bfs(0, j, board);
            if (board[r - 1][j] == 'O') bfs(r - 1, j, board);
        }
        //转换
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = board[i][j] == '*' ? 'O' : 'X';
            }
        }
    }

    //广搜
    private void bfs(int i, int j, char[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                if (x >= 0 && x < r && y >= 0 && y < c && board[x][y] == 'O') {
                    board[x][y] = '*';
                    for (int[] dir : dirs) {
                        queue.offer(new int[]{x + dir[0], y + dir[1]});
                    }
                }
            }
        }
    }
}
