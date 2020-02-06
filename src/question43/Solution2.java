package question43;

public class Solution2 {
    //时间复杂度:O(MN)
    public String multiply(String num1, String num2) {
        if (num1==null||num2==null||num1.equals("0")||num2.equals("0")||num1.equals("")||num2.equals(""))return "0";
        //两数相乘积最多为M+N位
        int[] res=new int[num1.length()+num2.length()];
        for (int i=num1.length()-1;i>=0;i--){
            int x = num1.charAt(i) - '0';
            for (int j=num2.length()-1;j>=0;j--){
                int y = num2.charAt(j) - '0';
                int sum=x*y+res[i+j+1];
                res[i+j+1]=sum%10;
                res[i+j]+=sum/10;
            }
        }
        StringBuilder ans=new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            //积的最高位可能为零，省去不要
            if (i==0&&res[0]==0)continue;
            ans.append(res[i]);
        }
        return ans.toString();
    }
}
