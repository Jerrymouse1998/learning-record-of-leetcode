package offer16;

public class DichotomySolution {
    //时间复杂度：O(logn)
    public double myPow(double x, int n) {
        if (n == -1) return 1 / x;
        if (n == 0) return 1;
        if (n == 1) return x;
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return half * half * rest;
    }
}
