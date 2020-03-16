package question67;

public class Solution {
    //时间复杂度：O(Max(aLen,bLen))
    public String addBinary(String a, String b) {
        int carry=0,len=Math.max(a.length(),b.length());
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < len; i++) {
            int x=a.length()-i-1>=0?a.charAt(a.length()-1-i)-'0':0;
            int y=b.length()-i-1>=0?b.charAt(b.length()-1-i)-'0':0;
            int sum=x+y+carry;
            carry=sum/2;
            sb.append(sum%2);
        }
        if (carry>0)sb.append(carry);
        return sb.reverse().toString();
    }
}
