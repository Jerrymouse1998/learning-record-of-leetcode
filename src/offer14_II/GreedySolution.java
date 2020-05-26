package offer14_II;

public class GreedySolution {
    //时间复杂度：O(logn) 空间复杂度：O(1)
    public int cuttingRope(int n) {
        if (n<4) return n-1;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        //别忘了最后一段绳子，长度 n
        return (int) (res*n%1000000007);
    }
}
