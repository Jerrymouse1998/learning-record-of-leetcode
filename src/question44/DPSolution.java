package question44;

public class DPSolution {
    //时间复杂度：O(mn)	m、n分别是s和p的长度。
    public boolean isMatch(String s, String p) {
        if (p==null||p.isEmpty())return s==null||s.isEmpty();
        int slen = s.length(),plen=p.length();
        boolean[][] dp=new boolean[slen+1][plen+1];
        //初始化dp数组,dp[1][0]~dp[s.length][0]默认值flase不需要显式初始化为false
        dp[0][0]=true;
        //dp[0][1]~dp[0][p.length]只有p的j字符以及前面所有字符都为'*'才为true
        for (int j=1;j<=plen;j++)dp[0][j]=p.charAt(j-1)=='*'&&dp[0][j-1];
        //填写dp数组剩余部分
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                char si = s.charAt(i - 1),pj=p.charAt(j-1);
                if (si==pj||pj=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if (pj=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
            }
        }
        return dp[slen][plen];
    }
}
