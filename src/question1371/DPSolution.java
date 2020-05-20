package question1371;

import java.util.Arrays;

public class DPSolution {
    //时间复杂度：O(n)
    //空间复杂度：O(1)
    public int findTheLongestSubstring(String s) {
        int[] dp = new int[32];
        //初始化
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int status = 0;
        int ans = 0;
        //遍历
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //记录元音字母出现的次数,更新状态
            if (c == 'a') {
                status ^= (1 << 0);
            } else if (c == 'e') {
                status ^= (1 << 1);
            } else if (c == 'i') {
                status ^= (1 << 2);
            } else if (c == 'o') {
                status ^= (1 << 3);
            } else if (c == 'u') {
                status ^= (1 << 4);
            }
            //如果状态重复出现
            if (dp[status] >= 0) {
                ans = Math.max(ans, i - dp[status] + 1);
            } else {
                dp[status] = i + 1;
            }
        }
        return ans;
    }
}
