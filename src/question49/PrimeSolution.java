package question49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrimeSolution {
    //时间复杂度：O(n*k) k是字符串的最大长度
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null||strs.length==0)return new ArrayList<>();
        //26个字母分别对应一个素数
        int[] prime=new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        HashMap<Integer,List<String>> map=new HashMap<>();
        for (int i=0;i<strs.length;i++){
            int key=1;
            for (int j=0;j<strs[i].length();j++){
                //字符串的每个字符对应的素数的乘积key
                key*=prime[strs[i].charAt(j)-'a'];
            }
            if (map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else {
                map.put(key,new ArrayList<>());
                map.get(key).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}
