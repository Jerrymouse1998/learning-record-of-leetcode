package question66;

public class Solution {
    //时间复杂度：O(n)
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            //当前位是否是9，不是9+1返回即可
            if (digits[i]!=9){
                digits[i]++;
                return digits;
            }
            //当前位是9，+1进位剩余0
            digits[i]=0;
        }
        //走到这里说明全是9，新建长度+1数组，最高位是1其余都是0即可
        int[] ans=new int[digits.length+1];
        ans[0]=1;
        return ans;
    }
}
