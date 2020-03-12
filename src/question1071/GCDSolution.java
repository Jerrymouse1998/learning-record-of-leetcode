package question1071;

public class GCDSolution {
    //时间复杂度:O(n)    字符串拼接后比较O(n),辗转相除法O(logn)
    public String gcdOfStrings(String str1, String str2) {
        //判断是否存在最大公因子
        if (!(str1+str2).equals(str2+str1))return "";
        //求最大公因子长度
        int maxLen=GCD(str1.length(),str2.length());
        return str1.substring(0,maxLen);
    }
    //求辗转相除法求最大公约数
    private int GCD(int a, int b) {
        return b==0?a:GCD(b,a%b);
    }
}
