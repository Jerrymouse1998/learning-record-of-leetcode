package question49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountCharSolution {
    //时间复杂度：O(nk)，k是最长字符串的长度
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null||strs.length==0)return new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap<>();
        for (int i=0;i<strs.length;i++){
            //统计字符串中每个字符出现的次数
            int[] count=new int[26];
            for (int j=0;j<strs[i].length();j++){
                count[strs[i].charAt(j)-'a']++;
            }
            //将计数器转换成n#n#n#n#格式
            String key="";
            for (int k=0;k<count.length;k++){
                key+=count[k]+"#";
            }
            if (!map.containsKey(key))map.put(key,new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
