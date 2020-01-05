package question22;

import java.util.ArrayList;
import java.util.List;

public class BFSolution {
    public static void main(String[] args) {
        System.out.println(new BFSolution().generateParenthesis(3));
    }

    List<String> res=new ArrayList<>();
//    时间复杂度：O(2^2n*n)
    public List<String> generateParenthesis(int n) {
        dfs(0,"",n);
        return res;
    }

//    深度优先遍历得到所有组合序列，如果是有效序列，则加入结果集
    public void dfs(int index,String conbination,int n){
        if (index==2*n){
            if (isValid(conbination))res.add(conbination);
            return;
        }else {
            dfs(index+1,conbination+'(',n);
            dfs(index+1,conbination+')',n);
        }
    }

//    平衡法判断括号序列是否有效
    public boolean isValid(String s){
        int balance=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                balance++;
            }else {
                balance--;
            }
//            如果balance<0则说明，)出现在与其对应的(之前，或者)多于(
            if (balance<0)return false;
        }
        return balance==0;
    }
}
