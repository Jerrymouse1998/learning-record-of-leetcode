package question140;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class DPSolution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        //取得字典中最长单词的长度
        int maxLen = 0;
        //字典存入 HashSet 中加快查找
        HashSet<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
            maxLen = Math.max(maxLen, word.length());
        }
        return helper(s, maxLen, dict, new HashMap<String, LinkedList<String>>());
    }

    private List<String> helper(String s, int maxLen, HashSet<String> wordDict, HashMap<String, LinkedList<String>> cache) {
        //如果已经求过 S 的分割结果,直接将结果返回
        if (cache.containsKey(s)) return cache.get(s);
        LinkedList<String> res = new LinkedList<>();
        //S 为空，不需要拆分
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        // S 的[0,i]子串
        for (int i = 0; i < s.length(); i++) {
            //子串是字典中的单词
            if (i < maxLen && wordDict.contains(s.substring(0, i + 1))) {
                //遍历, [i+1,n] 字符串递归生成的拆分结果
                for (String temp : helper(s.substring(i + 1), maxLen, wordDict, cache)) {
                    // [0,i]单词和后序的拆分结果依次组合
                    res.add(s.substring(0, i + 1) + (temp.isEmpty() ? "" : " ") + temp);
                }
            }
        }
        //S 和 S的拆分结果 放入缓存后返回
        cache.put(s, res);
        return res;
    }
}
