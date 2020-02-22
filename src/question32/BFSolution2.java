package question32;

public class BFSolution2 {
    //时间复杂度：O(n^2)
    public int longestValidParentheses(String s) {
        if (s==null||s.equals(""))return 0;
        int maxLen=0;
        //遍历所有子串
        for (int i = 0; i < s.length(); i++) {
            int count=0;
            for (int j=i;j<s.length();j++){
                // ( +1,) -1
                if (s.charAt(j)=='(')count++;
                else count--;
                //小于0说明 )比(多，无效序列
                if (count<0)break;
                //有效序列，更新maxLen
                if (count==0)maxLen=Math.max(maxLen,j-i+1);
            }
        }
        return maxLen;
    }
}
