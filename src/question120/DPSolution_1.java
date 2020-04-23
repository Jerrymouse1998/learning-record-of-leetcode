package question120;

import java.util.List;

public class DPSolution_1 {
    //时间复杂度：O(r^2)	空间复杂度：O(r^2)
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int r = triangle.size();
        int c = triangle.get(r - 1).size();
        //初始化
        int[][] dp = new int[r][c];
        dp[0][0] = triangle.get(0).get(0);
        //状态转移
        for (int i = 1; i < r; i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        //最小路径和一定在dp数组最后一行中
        int ans = Integer.MAX_VALUE;
        for (int e : dp[r - 1]) {
            ans = Math.min(ans, e);
        }
        return ans;
    }
}
