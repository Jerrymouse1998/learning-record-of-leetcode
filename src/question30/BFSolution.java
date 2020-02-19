package question30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BFSolution {
    //时间复杂度：O(n*m)	n是s长度，m是words中单词个数。
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        if (words==null||words.length==0)return res;
        //单词个数、单词长度
        int wordNum = words.length,wordLen=words[0].length();
        //将words每个单词及其个数存入hashmap
        HashMap<String,Integer> allWords=new HashMap<>();
        for (String word : words) {
            Integer value = allWords.getOrDefault(word, 0);
            allWords.put(word,++value);
        }
        //遍历s每一个子串,剩余不足wordNum*wordLen个字符的子串不需要遍历
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            //将子串中出现的和words中相等的单词及其出现次数存入hashmap
            HashMap<String,Integer> hasWords=new HashMap<>();
            //记录字串中和words中相等单词数量
            int count=0;
            //统计字串中连续和words中相等的单词
            while (count<wordNum){
                String word = s.substring(i + count * wordLen, i + (count + 1) * wordLen);
                //如果word匹配words中的单词，就统计其出现次数
                if (allWords.containsKey(word)){
                    Integer value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word,++value);
                    //如果word出现次数超过words中这个单词的总数量则结束统计
                    if (hasWords.get(word)>allWords.get(word))break;
                }else {
                    //如果字串中出现于words中所有单词都不匹配的word则结束统计
                    break;
                }
                //增加成功与words中匹配的单词数量
                count++;
            }
            if (count==wordNum)res.add(i);
        }
        return res;
    }
}
