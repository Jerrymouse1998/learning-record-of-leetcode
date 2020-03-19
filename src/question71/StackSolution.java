package question71;

import java.util.Stack;

public class StackSolution {
    //时间复杂度：O(n)
    public String simplifyPath(String path) {
        if (path == null || path.equals("")) return "/";
        //分割
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        //遍历数组，分别判断进行出入栈
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!split[i].equals("..") && !split[i].equals("") && !split[i].equals(".")) {
                stack.push(split[i]);
            }
        }
        //栈空
        if (stack.isEmpty()) return "/";
        //拼接
        StringBuilder ans = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            ans.append("/").append(stack.get(i));
        }
        return ans.toString();
    }
}
