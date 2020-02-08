package question49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SortArraySolution {
    //时间复杂度：O(n*klogk) n为元素个数，k为最长字符串长度，klogk是排序的时间复杂度
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null||strs.length==0)return new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap<>();
        //遍历每个字符串
        for (int i=0;i<strs.length;i++){
            //将么个字符串中的字符按字典排序后作为key
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            //key作为key，strs[i]作为value集合中的元素
            if (!map.containsKey(key))map.put(key,new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
