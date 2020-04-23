package question120;

import java.util.List;

public class DPSolution_3 {
    //时间复杂度：O(r^2)	空间复杂度：O(r)
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int r = triangle.size();
        //因为自底向上，所以计算最后一行i的时候，需要i+1行的最小路径和。
        int[] dp = new int[r + 1];
        //状态转移
        for (int i = r - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
            }
        }
        return dp[0];
    }
}
