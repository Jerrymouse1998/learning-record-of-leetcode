package question32;

import java.util.Stack;

public class BFSolution {
    //时间复杂度：O(n^3)
    public int longestValidParentheses(String s) {
        if (s==null||s.equals(""))return 0;
        int maxLen=0;
        //遍历所有子串
        for (int i = 0; i < s.length(); i++) {
            //只要偶数长度的，奇数长度一定无效
            for (int j=i+2;j<=s.length();j++){
                if (isValid(s.substring(i,j))){
                    maxLen=Math.max(maxLen,j-i);
                }
            }
        }
        return maxLen;
    }
    //判断括号序列是否有效
    private boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                stack.push('(');
            }else if (stack.size()>0){
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
