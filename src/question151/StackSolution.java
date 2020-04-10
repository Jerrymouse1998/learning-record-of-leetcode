package question151;

import java.util.Stack;

public class StackSolution {

    public String reverseWords(String s) {
        if (s==null)return s;
        Stack<String> stack=new Stack<>();
        //将单词都入栈
        StringBuilder sb=new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            }else {
                stack.push(sb.toString());
                sb=new StringBuilder();
            }
        }
        stack.push(sb.toString());
        //都出栈
        StringBuilder ans=new StringBuilder();
        while (!stack.isEmpty()) {
            //空串跳过
            if (!stack.peek().equals(""))ans.append(stack.peek()).append(' ');
            stack.pop();
        }
        return ans.toString().trim();
    }
}
