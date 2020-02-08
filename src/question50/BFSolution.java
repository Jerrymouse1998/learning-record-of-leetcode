package question50;

public class BFSolution {
    //时间复杂度：O(n)
    public double myPow(double x, int n) {
        if (x==0)return 0;
        if (n==0)return 1;
        double ans=1;
        long N=n;
        if (N<0){
            N=-N;
            x=1/x;
        }
        for (int i=0;i<N;i++){
            ans*=x;
        }
        return ans;
    }
}
