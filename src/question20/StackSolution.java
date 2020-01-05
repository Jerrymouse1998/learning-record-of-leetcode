package question20;

import java.util.HashMap;
import java.util.Stack;

public class StackSolution {

    public boolean isValid(String s) {
        int len=s.length();
        if (s==null||len==0)return true;
//        用hashmap存储括号对
        HashMap<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
//        用栈来保存遍历到的'(' '[' '{'
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<len;i++){
            char c = s.charAt(i);
//            如果map中没有c这个key，则说明c是(或[或{,就存入栈中（题目说只有六种字符）
            if (!map.containsKey(c)){
                stack.push(c);
            }else {//如果存在c这个key则说明，c是)或]或}，就需要去和栈顶字符进行匹配
//                如果栈为空，则无法匹配
                if (stack.size()==0)return false;
//                取出栈顶元素
                Character top = stack.pop();
//                如果map中c的value和栈顶元素top不相等，则无法匹配
                if (map.get(c)!=top)return false;
            }
        }
//        遍历完所有字符之后，检查栈是否为空，如果为空则匹配，反之无法匹配
        return stack.isEmpty();
    }
}
