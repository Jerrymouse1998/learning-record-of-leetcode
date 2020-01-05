package question8;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi(".9"));
    }

    public int myAtoi(String str) {
//        如果字符串为空直接返回0
        if(str==null)return 0;
//        1.去掉所有空格
        String s = str.trim();
//        如果去掉空格之后字符串为空，就返回0
        if (s.equals(""))return 0;
//        2.判断正负号
        int flag=1;
        if (s.charAt(0)=='-')flag=-1;
//        3.找出连续的数字
        int ans=0;
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c>='0'&&c<='9'){//数字
    //            溢出判断
                if (flag==1){
                    if (ans>Integer.MAX_VALUE/10||(ans==Integer.MAX_VALUE/10&&c-'0'>7))return Integer.MAX_VALUE;
                }else {
                    if (ans*flag<Integer.MIN_VALUE/10||(ans*flag==Integer.MIN_VALUE/10&&c-'0'>8))return Integer.MIN_VALUE;
                }
                ans=ans*10 +c-'0';
            }else if ((c=='-'||c=='+')&&i<1){//c不是数字，但c是正负号并且是第一个字符
//             空方法体，什么也不操作，进入第二次循环
            }else{//既不是数字，也不是第一个正负号字符，直接结束循环
                break;
            }
        }
        return ans*flag;
    }
}
