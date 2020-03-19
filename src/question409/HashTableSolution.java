package question409;

import java.util.HashMap;

public class HashTableSolution {
    //时间复杂度：O(n)
    public int longestPalindrome(String s) {
        if (s==null||s.length()<1)return 0;
        int len = s.length(),maxLen=0;
        HashMap<Character,Integer> map=new HashMap<>();
        //遍历字符串
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            Integer value = map.getOrDefault(c, 0);
            //如果当前字符已经存在一个，可以成对则加入回文子串，并重新计数
            if (value==1){
                maxLen+=2;
                map.put(c,0);
            }else {
                map.put(c,1);
            }
        }
        //如果有未使用的字符，可以任取一个作为中心
        return maxLen==len?maxLen:maxLen+1;
    }

    //public int longestPalindrome(String s) {
    //    if (s==null||s.length()<1)return 0;
    //    int len = s.length(),maxLen=0;
    //    int[] map=new int[128];
    //    //遍历字符串
    //    for (int i = 0; i < len; i++) {
    //        char c = s.charAt(i);
    //        //如果当前字符已经存在一个，可以成对则加入回文子串，并重新计数
    //        if (map[c]==1){
    //            maxLen+=2;
    //            map[c]=0;
    //        }else {
    //            map[c]=1;
    //        }
    //    }
    //    //如果有未使用的字符，可以任取一个作为中心
    //    return maxLen==len?maxLen:maxLen+1;
    //}
}
