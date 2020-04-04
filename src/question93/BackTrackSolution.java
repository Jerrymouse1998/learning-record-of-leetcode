package question93;

import java.util.ArrayList;
import java.util.List;

public class BackTrackSolution {

    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        dfs(0, "", 4, s);
        return res;
    }

    /**
     * dfs回溯
     *
     * @param curLen      ip串中数字的长度，初始0
     * @param combination 正在组合的ip串，初始空串
     * @param del         ip串中还可以插入的'.'的数量，初始4
     * @param s           参数字符串
     */
    private void dfs(int curLen, String combination, int del, String s) {
        //当前ip串中数字的数量等于s的长度，并且四个'.'都已经使用完毕
        if (curLen == s.length() && del == 0) {
            res.add(combination.substring(0, combination.length() - 1));
            return;
        }
        //ip串中'.'超过四个
        if (del < 0) return;
        //ip段最多三位
        for (int j = curLen; j < curLen + 3; j++) {
            //边界
            if (j < s.length()) {
                //ip段第一个数字是0，无法和后续数字组合，只能作为一位的ip段
                if (j == curLen && s.charAt(j) == '0'){
                    dfs(j + 1, combination + s.charAt(j) + '.', del - 1, s);
                    break;
                }
                //ip段中的数字在[0,255]区间内，可以作为一个ip段
                if (Integer.parseInt(s.substring(curLen, j + 1)) <= 255)
                    dfs(j + 1, combination + s.substring(curLen, j + 1)+'.', del - 1, s);
            }
        }
    }
}
