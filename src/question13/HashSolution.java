package question13;

import java.util.HashMap;
import java.util.Map;

public class HashSolution {
    public int romanToInt(String s) {
        int ans=0;
//        把所有罗马数字和阿拉伯数字相互匹配的特殊值作为键值对存储起来
        Map<String,Integer> map=new HashMap();
        map.put("M",1000);
        map.put("CM",900);
        map.put("D",500);
        map.put("CD",400);
        map.put("C",100);
        map.put("XC",90);
        map.put("L",50);
        map.put("XL",40);
        map.put("X",10);
        map.put("IX",9);
        map.put("V",5);
        map.put("IV",4);
        map.put("I",1);
//        逐步分割字符串，两位罗马数字优先于一位罗马数字
        for (int i=0;i<s.length();){
            if (i+1<s.length()&&map.containsKey(s.substring(i,i+2))){
                ans+=map.get(s.substring(i,i+2));
                i+=2;
            }else {
                ans+=map.get(s.substring(i,i+1));
                i++;
            }
        }
        return ans;
    }
}
