package question150;

import java.util.Stack;

public class Solution {
    //时间复杂度：O(n)	空间复杂度：O(n) 栈内元素最多 n/2+1 个
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("-")) {
                //注意运算顺序
                stack.push(-stack.pop() + stack.pop());
            } else if (token.equals("/")) {
                //注意运算顺序
                Integer divisor = stack.pop();
                stack.push(stack.pop() / divisor);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
