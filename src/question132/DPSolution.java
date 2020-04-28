package question132;

public class DPSolution {
    //时间复杂度：O(n^2)  空间复杂度：O(n^2)
    public int minCut(String s) {
        if (s == null || s.length() < 2) return 0;
        int len = s.length();
        int[] dp = new int[len];
        //初始化
        for (int right = 0; right < len; right++) {
            dp[right] = right;
        }
        //预处理
        boolean[][] isPalindrome = new boolean[len][len];
        isPalindrome[0][0] = true;
        for (int right = 0; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                isPalindrome[left][right] = s.charAt(left) == s.charAt(right)
                        && (right - left <= 2 || isPalindrome[left + 1][right - 1]);
            }
        }
        //状态转移
        for (int right = 1; right < len; right++) {
            if (isPalindrome[0][right]) {
                dp[right] = 0;
            } else {
                //left是分隔点!分隔后的区间是[0,left]和[left+1,right]
                for (int left = 0; left < right; left++) {
                    if (isPalindrome[left + 1][right]) {
                        dp[right] = Math.min(dp[right], dp[left] + 1);
                    }
                }
            }
        }
        return dp[len - 1];
    }
}
