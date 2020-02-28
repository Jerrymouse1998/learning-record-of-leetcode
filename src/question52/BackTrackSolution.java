package question52;

public class BackTrackSolution {
    //时间复杂度：O(n!)
    int count=0;
    public int totalNQueens(int n) {
        //棋盘,默认为0表示空，1表示皇后
        int[][] board=new int[n][n];
        //row当前填写得的行号
        dfs(n,0,board);
        return count;
    }

    //深度优先遍历
    private void dfs(int n, int row, int[][] board) {
        //0~n-1都填写完毕
        if (row==n){
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isUsable(board,row,col)){
                board[row][col]=1;
                //填写下一行
                dfs(n,row+1,board);
                board[row][col]=0;
            }
        }
    }

    //board[row][col]是否可用
    private boolean isUsable(int[][] board, int row, int col) {
        //检查列上有无皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col]==1)return false;
        }
        //检查左上至右下对角线有无皇后
        for (int i = col-1; i >= 0; i--) {
            if (i+row-col<0)break;
            if (board[i+row-col][i]==1)return false;
        }
        //检查右上至左下对角线有无皇后
        for (int i = col+1; i < board.length; i++) {
            if (row+col-i<0)break;
            if (board[row+col-i][i]==1)return false;
        }
        return true;
    }

}
