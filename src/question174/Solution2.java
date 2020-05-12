package question174;

import java.util.Arrays;

public class Solution2 {
    //时间复杂度：O(n*m)	空间复杂度：O(m)
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[m - 1] = dungeon[n - 1][m - 1] > 0 ? 1 : -dungeon[n - 1][m - 1] + 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) continue;
                dp[j] = Math.min(dp[j], dp[j + 1]) - dungeon[i][j];
                if (dp[j] <= 0) dp[j] = 1;
            }
        }
        return dp[0];
    }
}
