package question01_06;

public class Solution {
    //时间复杂度：O(n)
    public String compressString(String S) {
        if (S==null||S.length()<2)return S;
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int count=1;
            char c = S.charAt(i);
            while (i<S.length()-1&&c==S.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(c).append(count);
        }
        return sb.length()<S.length()?sb.toString():S;
    }
}
