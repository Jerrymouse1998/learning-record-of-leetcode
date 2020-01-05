package question29;

public class BisectionSolution {
//    时间复杂度：O(logN)
    public int divide(int dividend, int divisor) {
        if (divisor==0)throw new IllegalArgumentException();
//        将除数和被除数异或之后，得到商的符号
        boolean isPositive=(dividend^divisor)>=0;
//        将除数和被除数都转化为负数
        if (dividend>0)dividend=opposite(dividend);
        if (divisor>0)divisor=opposite(divisor);
//        商用负数来表示，这样可以处理Integer.MIN_VALUE的情况
        int ans=0;
        while (dividend<=divisor){
            int tempDivisor=divisor;
            int count=-1;
//            这里注意需要对tempDivisor是否为负数做判断，因为tempDivisor有可能会溢出
            while (tempDivisor<0&&dividend<=tempDivisor){
//                被除数-除数
                dividend-=tempDivisor;
                ans+=count;
//                除数翻倍
                tempDivisor+=tempDivisor;
                count+=count;
            }
        }
//      对返回值进行处理，这里也可以使用三目运算符完成
        if (isPositive){
            if (ans==Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return opposite(ans);
            }
        }else {
            return ans;
        }
    }
//    x的反码+1，得到x的相反数
    private int opposite(int x){
        return ~x+1;
    }
}
