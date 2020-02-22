package question30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SlidingWindowSolution {
    //时间复杂度：O(n*wordLen)    这个时间复杂度不敢确定算的对。。。
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<>();
        if (s==null||words==null||words.length==0)return result;
        int wordsNum = words.length,wordLen=words[0].length();
        //将words中的单词及其数量存入hashmap
        HashMap<String,Integer> allWords=new HashMap<>();
        for (String word : words) {
            Integer value = allWords.getOrDefault(word, 0);
            allWords.put(word,value+1);
        }
        //分成wordLen中情况，分别从0开始每次移动一个单词长度~从wordLen-1开始每次移动一个单词长度
        for (int j=0;j<wordLen;j++){
            //haswords存放当前子串中匹配的单词及其个数，count当前子串匹配的单词数量
            HashMap<String,Integer> haswords=new HashMap<>();
            int count=0;
            //遍历从j开始的每个子串，每次动一个单词长度
            for (int i=j;i<s.length()-wordLen*wordsNum+1;i+=wordLen){
                //防止情况三出现之后，情况一继续移除
                boolean hasRemoved=false;
                while (count<wordsNum){
                    String curWord = s.substring(i + count * wordLen, i + (count + 1) * wordLen);
                    //当前单词匹配，加入haswords
                    if (allWords.containsKey(curWord)) {
                        Integer value = haswords.getOrDefault(curWord, 0);
                        haswords.put(curWord,value+1);
                        count++;
                        //情况三，当前单词匹配，但是数量超了
                        if (haswords.get(curWord) > allWords.get(curWord)) {
                            hasRemoved=true;
                            //从i开始逐个单词，从haswords中移除，removeNum记录移除的单词个数
                            int removeNum=0;
                            while (haswords.get(curWord) > allWords.get(curWord)) {
                                String fristWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                Integer v = haswords.get(fristWord);
                                haswords.put(fristWord,v-1);
                                removeNum++;
                            }
                            //移除完毕之后，更新count
                            count-=removeNum;
                            //移动i的位置(注意removeNum要-1，因为跳出当前循环之后，i还要+wordLen)
                            i+=(removeNum-1)*wordLen;
                            break;
                        }
                    }else{//情况二，当前单词不匹配
                        //清空haswords
                        haswords.clear();
                        //i移动到当前单词位置(因为跳出当前循环之后，i还要+wordLen)
                        i+=count*wordLen;
                        count=0;
                        break;
                    }
                }
                //情况一，匹配成功
                if (count==wordsNum)result.add(i);
                //如果情况三没有出现
                if (count>0&&!hasRemoved){
                    //移除成功匹配子串的第一个元素
                    String fristWord = s.substring(i, i + wordLen);
                    Integer v = haswords.get(fristWord);
                    haswords.put(fristWord,v-1);
                    count--;
                }
            }
        }
        return result;
    }
}
