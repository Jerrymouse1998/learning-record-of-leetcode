package question76;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowSolution {
    //时间复杂度：O(n)	n是s的长度，最坏情况就是左右边界指针各遍历一次s，2n。
    public String minWindow(String s, String t) {
        if (s == null || s.equals("") || t == null || t.equals("") || t.length() > s.length()) return "";
        //保存t中所有字符和个数
        Map<Character, Integer> allMap = new HashMap<>();
        //记录窗口中字符和个数
        Map<Character, Integer> window = new HashMap<>();
        //统计t中字符
        for (char c : t.toCharArray()) {
            allMap.put(c, allMap.getOrDefault(c, 0) + 1);
        }
        //left、right窗口边界，count窗口中符合要求的元素个数，minLen符合要求的最小子串长度
        int left = 0, right = 0, count = 0, minLen = s.length();
        String res = "";
        while (right < s.length()) {
            //当前元素计入窗口
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            //如果当前元素符合要求，则count++
            if (allMap.containsKey(c) && allMap.get(c) >= window.get(c)) {
                count++;
            }
            //当窗口子串符合条件即找到满足条件的子串，缩小窗口，进行子串优化
            while (count == t.length()) {
                char ch = s.charAt(left);
                //更新minLen，主要是<=  s:"aa" t:"aa"的情况也要更新
                if ((right - left + 1) <= minLen) {
                    minLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                //缩小窗口
                if (allMap.containsKey(ch) && allMap.getOrDefault(ch, 0) >= window.get(ch)) {
                    count--;
                }
                window.put(ch, window.get(ch) - 1);
                left++;
            }
            right++;
        }
        return res;
    }
}
