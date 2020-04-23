package question120;

import java.util.List;

public class DPSolution_2 {
    ////时间复杂度：O(r^2)	空间复杂度：O(r)
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int r = triangle.size();
        //初始化
        int[] dp = new int[r];
        dp[0] = triangle.get(0).get(0);
        //记录dp[i - 1][j]和dp[i - 1][j - 1]
        int left = 0, right;
        //状态转移
        for (int i = 1; i < r; i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                right = dp[j];
                if (j == 0) {
                    dp[j] = right + row.get(j);
                } else if (j == i) {
                    dp[j] = left + row.get(j);
                } else {
                    dp[j] = Math.min(left, right) + row.get(j);
                }
                left = right;
            }
        }
        //找出最小的路径和
        int ans = Integer.MAX_VALUE;
        for (int e : dp) {
            ans = Math.min(ans, e);
        }
        return ans;
    }
}
