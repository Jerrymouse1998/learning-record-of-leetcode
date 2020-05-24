package offer12;

public class BackTrackSolution {
    //时间复杂度：O(mn*3^K)
    //最坏情况：有m*n个起点，每个起点都要遍历一个 word长度k的方案，除去上一个字符，还有 3 个方向
    //空间复杂度：O(k)递归调用栈不超过 k 层深度
    int m, n;
    boolean finished = false;

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && bfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, String word, int i, int j, int curLen) {
        if (curLen == word.length()) {
            finished = true;
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(curLen)) {
            return false;
        }
        if (finished) {
            return true;
        } else {
            char c = board[i][j];
            board[i][j] = '.';
            boolean up = bfs(board, word, i - 1, j, curLen + 1);
            boolean down = bfs(board, word, i + 1, j, curLen + 1);
            boolean left = bfs(board, word, i, j - 1, curLen + 1);
            boolean right = bfs(board, word, i, j + 1, curLen + 1);
            board[i][j] = c;
            return up || down || left || right;
        }
    }
}
