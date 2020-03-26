package question999;

public class Solution {
    //时间复杂度：O(n^2)	最坏情况遍历一次棋盘加两条边，就是n^2+2n。
    public int numRookCaptures(char[][] board) {
        int ans = 0;
        //找R的位置
        int[] index = findR(board);
        //R四个方向上进行捕获
        int i = index[0], j = index[1];
        //向下
        for (int k = i + 1; k < 8; k++) {
            if (board[k][j] == 'B') break;
            if (board[k][j] == 'p') {
                ans++;
                break;
            }
        }
        //向右
        for (int k = j + 1; k < 8; k++) {
            if (board[i][k] == 'B') break;
            if (board[i][k] == 'p') {
                ans++;
                break;
            }
        }
        //向上
        for (int k = i - 1; k >= 0; k--) {
            if (board[k][j] == 'B') break;
            if (board[k][j] == 'p') {
                ans++;
                break;
            }
        }
        //向左
        for (int k = j; k >= 0; k--) {
            if (board[i][k] == 'B') break;
            if (board[i][k] == 'p') {
                ans++;
                break;
            }
        }
        return ans;
    }

    private int[] findR(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{8, 8};
    }
}
