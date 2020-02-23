package question32;

public class DPSolution {
    //时间复杂度：O(n)
    public int longestValidParentheses(String s) {
        if (s==null||s.equals(""))return 0;
        int maxLen=0;
        int[] dp=new int[s.length()];
        //遍历每个字符并填写dp数组。大量的if else可以用三元运算符优化
        for (int i=1;i<s.length();i++){
            //如果i是')'，分两种情况
            if (s.charAt(i)==')'){
                //情况一，i-1是'('。则可以和i有效组合。
                if (s.charAt(i-1)=='('){
                    if (i-2>=0) dp[i]=dp[i-2]+2;
                    else dp[i]=2;
                }else {//情况二，i-1是')'
                    //如果i之前的有效序列之前是个左括号，则可以和i有效组合。否则i结尾的序列无效
                    if (i-dp[i-1]-1>=0&&s.charAt(i-dp[i-1]-1)=='('){
                        if (i-dp[i-1]-2>=0)dp[i]=dp[i-1]+dp[i-dp[i-1]-2]+2;
                        else dp[i]=dp[i-1]+2;
                    }
                }
            }
            //更新maxLen
            maxLen=Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}
