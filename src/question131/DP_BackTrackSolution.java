package question131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DP_BackTrackSolution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.equals("")) return res;
        //预处理,得到dp数组
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int right = 0; right < s.length(); right++) {
            //区间左端点left要小于等于区间右端点right
            for (int left = 0; left <= right; left++) {
                dp[left][right] = s.charAt(right) == s.charAt(left)
                        && (right - left <= 2 || dp[left + 1][right - 1]);
            }
        }
        dfs(s, 0, new LinkedList<String>(), dp);
        return res;
    }

    /**
     * 回溯
     *
     * @param s     输入串
     * @param start 分割起点
     * @param track 路径上分割出来的子串
     */
    private void dfs(String s, int start, LinkedList<String> track, boolean[][] dp) {
        //分割完毕
        if (start == s.length()) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            //如果子串不是回文,剪枝
            if (dp[start][i]) {
                track.add(s.substring(start, i + 1));
                dfs(s, i + 1, track, dp);
                track.removeLast();
            }
        }
    }
}
