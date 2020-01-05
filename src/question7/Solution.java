package question7;

public class Solution {
//时间复杂度O(logn)
    public int reverse(int x) {
        int ans=0;
        while (x!=0){
            int t=x%10;
            x/=10;
            if (ans>Integer.MAX_VALUE/10||(ans==Integer.MAX_VALUE&&t>7))return 0;
            if (ans<Integer.MIN_VALUE/10||(ans==Integer.MIN_VALUE&&t<-8))return 0;
            ans=ans*10+t;
        }
        return ans;
    }
}
