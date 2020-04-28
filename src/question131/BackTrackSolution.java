package question131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BackTrackSolution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.equals("")) return res;
        dfs(s, 0, new LinkedList<String>());
        return res;
    }

    /**
     * 回溯
     *
     * @param s     输入串
     * @param start 分割起点
     * @param track 路径上分割出来的子串
     */
    private void dfs(String s, int start, LinkedList<String> track) {
        //分割完毕
        if (start == s.length()) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            //如果子串不是回文,剪枝
            if (isPalindrome(s, start, i)) {
                track.add(s.substring(start, i + 1));
                dfs(s, i + 1, track);
                track.removeLast();
            }
        }
    }

    //双指针判断子串是否回文
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
