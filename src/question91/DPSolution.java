package question91;

public class DPSolution {
    //时间复杂度：O(n)
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];
        //初始化
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;
        //状态转移
        for (int i = 2; i <= s.length(); i++) {
            //记录当前字符和前一个字符组成的一个两位数
            int x = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (s.charAt(i - 1) == '0' && s.charAt(i - 2) == '0') {//1
                return 0;
            } else if (s.charAt(i - 2) == '0') {//2
                dp[i]=dp[i-1];
            } else if (s.charAt(i - 1) == '0') {//3
                if (x>26)return 0;
                dp[i]=dp[i-2];
            } else if (x > 26) {//4
                dp[i]=dp[i-1];
            }else {
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
