package question79;

public class BackTrackSolution {
    //时间复杂度：O((mn)^2)   mn分别是行列。主函数遍历是mn。
    // 深搜最坏情况是word是Z字形占满board，四个方向调用深搜，全部都要搜一遍board，深搜是4*mn。
    // 总的就是4*mn*mn。

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
