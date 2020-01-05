package question3;

import java.util.HashSet;
import java.util.Set;

public class BFSolution {
    public static void main(String[] args) {
        System.out.println(new SlidingWindowSolution().lengthOfLongestSubstring(" "));
    }

//    时间复杂度：O(n^3)
    public int lengthOfLongestSubstring(String s) {
        int count=0;
//        用两个for循环枚举所有子串
        for (int i=0;i<s.length();i++){
            for (int j=i+1;j<=s.length();j++){
//                调用allUnique方法校验子串中是否都是唯一的字符
                if (allUnique(s,i,j))
                    count=Math.max(count,j-i);
            }
        }
        return count;
    }
//    校验子串中是否都是唯一的字符
    private boolean allUnique(String s, int start, int end) {
        Set set=new HashSet();
        for (;start<end;start++){
            if (set.contains(s.charAt(start)))return false;
            set.add(s.charAt(start));
        }
        return true;
    }
}
