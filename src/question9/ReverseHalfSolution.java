package question9;

public class ReverseHalfSolution {
    public boolean isPalindrome(int x) {
//        两种不是回文数的特殊情况
        if (x<0||(x!=0&&x%10==0))return false;
//        后半部分翻转后的数字
        int reversedNumber=0;
        while (x>reversedNumber){
            reversedNumber=reversedNumber*10+x%10;
            x/=10;
        }
//        x可能是的位数可能是偶数或基数，如果是基数直接reversedNumber/10,简单的去掉中间的数
        return x==reversedNumber||x==reversedNumber/10;
    }
}
