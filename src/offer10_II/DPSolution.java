package offer10_II;

public class DPSolution {
    //时间复杂度：O(n)    空间复杂度：O(n)
    //public int numWays(int n) {
    //    if (n == 0) return 1;
    //    int[] dp = new int[n + 1];
    //    dp[0] = dp[1] = 1;
    //    for (int i = 2; i < n + 1; i++) {
    //        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
    //    }
    //    return dp[n];
    //}

    //时间复杂度：O(n)    空间复杂度：O(n)
    public int numWays(int n) {
        int a = 1, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
