package question28;

import java.util.HashMap;
import java.util.Map;

public class SundaySolution {
    public static void main(String[] args) {
        String haystack="mississippi",needle="issi";
        System.out.println(new SundaySolution().strStr(haystack,needle));
    }

//    时间复杂度：O(nm)
    public int strStr(String haystack,String needle){
        if (needle.equals(""))return 0;
        int hLen=haystack.length(),nLen=needle.length();
        if (hLen<nLen)return -1;
//        创建偏移表
        Map<Character,Integer> offsetMap=new HashMap<>();
        for (int i=0;i<nLen;i++){
            offsetMap.put(needle.charAt(i),nLen-i);
        }
//        开始查找模式串
        int idx=0;
//        循环直至idx+模式串长度>目标字符串长度
        while (idx+nLen<=hLen){
//            截取目标字符串
            String cutHay = haystack.substring(idx, idx + nLen);
//            如果子串和模式串相等，则返回idx
            if (cutHay.equals(needle)){
                return idx;
            }else {
//                边界处理，如果子串后面已经没有字符，即已经是最后一组子串，则搜索失败
                if(idx+nLen>=hLen)return -1;
//                如果子串在目标串中的后一个字符c是否存在于偏移表中
                if (offsetMap.containsKey(haystack.charAt(idx+nLen))){
                    idx+=offsetMap.get(haystack.charAt(idx+nLen));
                }else {
                    idx+=nLen+1;
                }
            }
        }
        return -1;
    }
}
