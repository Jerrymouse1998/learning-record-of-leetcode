package question69;

public class DichotomySolution {
    //时间复杂度：O(logn)
    public int mySqrt(int x) {
        if (x==0)return 0;
        long left=1,right=x/2;
        while (left < right) {
            //取右中位数
            long mid=(left+right+1)>>>1;//(right-left+1)/2+left
            long square=mid*mid;
            if (square > x) {//向左收缩
                right=mid-1;
            }else {
                left=mid;
            }
        }
        return (int)left;
    }
}
