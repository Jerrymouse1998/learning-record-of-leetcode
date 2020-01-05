package question3;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowSolution {
    public static void main(String[] args) {
        System.out.println(new SlidingWindowSolution().lengthOfLongestSubstring("tmmzuxt"));
    }

    public int lengthOfLongestSubstring(String s) {

//      //    时间复杂度：O(2n) = O(n)
//              Set set=new HashSet();
//              int count=0,i=0,j=0;
//              while (i<s.length()&&j<s.length()){
//      //            如果s.charAt(j))已经在set中，
//                  if (set.contains(s.charAt(j))){
//                        将i元素从滑动窗口中移除，并将i向右滑动一步
//                      set.remove(s.charAt(i++));
//                  }else { //s.charAt(j))不在set中，
//                        将j元素放入滑动窗口中，并将j向右滑动一步
//                      set.add(s.charAt(j++));
//                         更新count
//                      count = Math.max(j-i,count);
//                  }
//              }
//              return count;


        /**
         * 上述方法最坏情况需要执行2n次，我们可以将它减少为执行n次。
         * 上述方法中滑动窗口当第j个元素在窗口中发生重复时，就删除第i个元素并且将i向前移动一步，
         * 有时候需要i多次移动之后才能使第j个元素不重复。
         * 我们可以使用hashmap代替hashset，就可以将元素及其下标组成k-v对存入hashmap，
         * 当发生第j个元素重复时，就可以一次将i移动到位。
         */
        int count=0;
        Map<Character,Integer> map=new HashMap();
        for (int j=0,i=0;j<s.length();j++){
            char c=s.charAt(j);
//          无论是否更新start，都会更新其map数据结构和结果ans。
            if (map.containsKey(c)){
//              移动到集合中重复字符下标的下一位。
                i=Math.max(i,map.get(c)+1);
            }
            map.put(c,j);
            count=Math.max(j-i+1,count);
        }
        return count;
    }
}
