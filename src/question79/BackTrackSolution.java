package question79;

public class BackTrackSolution {
    //时间复杂度：O(mn*3^K)
    //最坏情况：有m*n个起点，每个起点都要遍历一个 word长度k的方案，除去上一个字符，还有 3 个方向
    //空间复杂度：O(k)递归调用栈不超过 k 层深度

    //是否成功搜索word
    boolean finished = false;

    public boolean exist(char[][] board, String word) {
        //遍历
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //如果等于word第一个字符的元素，以i j 开始进行四个方向深搜
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int curr) {
        //匹配成功的长度等于word长度，成功搜索
        if (curr == word.length()) {
            finished = true;
            return true;
        }
        //如果到的边界或者字符不匹配
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] != word.charAt(curr)) {
            return false;
        }
        //当前未完成匹配，继续四个方向深搜
        if (!finished) {
            char c = board[i][j];//保存当前字符，回溯的时候重新填写回去
            board[i][j] = '.';//沉岛
            boolean down = dfs(board, word, i + 1, j, curr + 1);//向下搜
            boolean right = dfs(board, word, i, j + 1, curr + 1);//向右搜
            boolean up = dfs(board, word, i - 1, j, curr + 1);//向上搜
            boolean left = dfs(board, word, i, j - 1, curr + 1);//向左搜
            board[i][j] = c;//回溯重新将字符填回去
            return down || right || up || left;
        } else {
            return true;//已完成
        }
    }
}
