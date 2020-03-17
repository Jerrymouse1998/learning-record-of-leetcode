package question1160;


import java.util.HashMap;

public class HashTableSolution {
    //时间复杂度：O(n+m)  n是words字符数量，m是chars字符数量
    public int countCharacters(String[] words, String chars) {
        if (chars==null||chars.length()<1)return 0;
        //统计chars
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            Integer value = map.getOrDefault(chars.charAt(i), 0);
            map.put(chars.charAt(i),value+1);
        }
        //遍历每个单词
        int count=0;
        for (int i = 0; i < words.length; i++) {
            //临时长度遍历，临时表，有效标志
            int temp=0;
            HashMap<Character,Integer> has=new HashMap<>();
            boolean ok=true;
            //遍历单词每个字符
            for (int j = 0; j < words[i].length(); j++) {
                //存在于map
                if (map.containsKey(words[i].charAt(j))){
                    int value=has.getOrDefault(words[i].charAt(j),0);
                    has.put(words[i].charAt(j),value+1);
                    temp++;
                    //数量超了
                    if (has.get(words[i].charAt(j))>map.get(words[i].charAt(j))){
                        ok=false;
                        break;
                    }
                }else {//不存在于map
                    ok=false;
                    break;
                }
            }
            //如果有效加入结果
            if (ok)count+=temp;
        }
        return count;
    }
}
