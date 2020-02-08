package question50;

public class DichotomySolution {
    //时间复杂度：O(logn)
    public double myPow(double x, int n) {
        switch (n){
            case 1:return x;
            case 0:return 1;
            case -1:return 1/x;
        }
        double half=myPow(x,n/2);
        double rest=myPow(x,n%2);
        return half*half*rest;
    }
}
