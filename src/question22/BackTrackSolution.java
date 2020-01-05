package question22;

import java.util.ArrayList;
import java.util.List;

public class BackTrackSolution {

    List<String> res=new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(0,0,"",n);
        return res;
    }

    /**
     *
     * @param l 左括号数量
     * @param r 有括号数量
     * @param combination 当前括号序列
     * @param n 输入n
     */
    public void dfs(int l,int r,String combination,int n){
//        当'('和')'的数量都是n个的时候，说明已经得到括号序列。
        if (l==n&&r==n){
            res.add(combination);
            return;
        }
//        '('数量小于n的时候，可以向序列中继续添加'('。
        if (l<n){
            dfs(l+1,r,combination+'(',n);
        }
//        ')'数量小于n并且当前')'数量小于当前'('数量时，才可以向序列中继续添加')'。
        if (r<n&&r<l){
            dfs(l,r+1,combination+')',n);
        }
    }
}
