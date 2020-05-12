package question174;

public class Solution {
    //时间复杂度：O(n*m)
    //空间复杂度：O(n*m)
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        //初始化
        dp[n - 1][m - 1] = dungeon[n - 1][m - 1] > 0 ? 1 : -dungeon[n - 1][m - 1] + 1;
        for (int i = 0; i < n + 1; i++) {
            dp[i][m] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[n][i] = Integer.MAX_VALUE;
        }
        //状态转移
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                //终点已经初始化了,不需要重复计算
                if (i == n - 1 && j == m - 1) continue;
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                //如果当前位置计算出最小血量为负数或0,说明只需要小血量 活着即可
                if (dp[i][j] <= 0) dp[i][j] = 1;
            }
        }
        return dp[0][0];
    }
}
