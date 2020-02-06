package question43;

public class Solution {

    //时间复杂度：O(MN)
    public String multiply(String num1, String num2) {
        if (num1==null||num2==null||num1.equals("0")||num2.equals("0")||num1.equals("")||num2.equals(""))return "0";
        StringBuilder ans=new StringBuilder();
        //遍历num2的每个元素
        for (int i=0;i<num2.length();i++){
            //逆序取出元素
            int x = num2.charAt(num2.length()-i-1)-'0',carry=0;
            StringBuilder temp=new StringBuilder();
            //除了第一次个位数，其他位需要在低位补相应数量的0
            for (int k=0;k<i;k++)temp.append(0);
            //依次与num1的每个元素相乘
            for (int j=0;j<num1.length();j++){
                //逆序取出元素
                int y = num1.charAt(num1.length()-j-1)-'0';
                //注意加上进位值
                int sum=x*y+carry;
                carry=sum/10;
                temp.append(sum%10);
            }
            //注意检查进位值，不要遗漏
            if (carry>0)temp.append(carry);
            //将每位上的乘法结果和ans相加
            ans=sum(ans,temp);
        }
        //最后需要将ans翻转，变成正确顺序
        return ans.reverse().toString();
    }
    //将两个字符串相加
    private StringBuilder sum(StringBuilder num1, StringBuilder num2) {
        StringBuilder ans=new StringBuilder();
        int carry=0,len=Math.max(num1.length(),num2.length());
        for (int i=0;i<len;i++){
            //两个字符串长度不相等的时候，短的那个在高位补0
            int x=i<num1.length()?num1.charAt(i)-'0':0;
            int y=i<num2.length()?num2.charAt(i)-'0':0;
            //注意加上进位
            int sum=x+y+carry;
            carry=sum/10;
            ans.append(sum%10);
        }
        //循环结束也要检查进位，防止遗漏
        if (carry>0)ans.append(carry);
        return ans;
    }
}
