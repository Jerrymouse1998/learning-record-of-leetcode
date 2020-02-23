package question32;

public class TwiceSolution {
    //时间复杂度：O(n)
    public int longestValidParentheses(String s) {
        if (s==null||s.equals(""))return 0;
        int left=0,right=0,maxLen=0;
        //正序遍历
        for (int i = 0; i < s.length(); i++) {
            //统计左右括号数量
            if (s.charAt(i)==')'){
                right++;
            }else {
                left++;
            }
            //左右括号数量相等，则有效序列，更新maxLen
            if (left==right){
                maxLen=Math.max(maxLen,right+left);
            }else if (left<right){//右括号多于左括号，无效序列，重置计数
                left=0;
                right=0;
            }
        }
        left=0;
        right=0;
        //逆序遍历
        for (int i = s.length()-1; i >= 0; i--) {
            //统计数量
            if (s.charAt(i)==')'){
                right++;
            }else {
                left++;
            }
            //如果左右括号数量相等，有效序列，更新maxLen
            if (left==right){
                maxLen=Math.max(maxLen,right+left);
            }else if (left>right){//如果左括号多于有括号，无效序列，重置计数
                left=0;
                right=0;
            }
        }
        return maxLen;
    }
}
