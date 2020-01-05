package question6;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().convert("leetcode",3));
    }
//  直接按行读取 时间复杂度：O(n)
    public String convert(String s, int numRows) {
        if (numRows==1)return s;
        StringBuilder ans=new StringBuilder();
        int len=s.length();
        int cycleLen=2*numRows-2;

        for (int i=0;i<numRows;i++){
            for (int j=0;j+i<len;j+=cycleLen){
                ans.append(s.charAt(j+i));
                if (i!=0 && i!=numRows-1 && j+cycleLen-i<len)
                    ans.append(s.charAt(j+cycleLen-i));
            }
        }
        return ans.toString();
    }
}
