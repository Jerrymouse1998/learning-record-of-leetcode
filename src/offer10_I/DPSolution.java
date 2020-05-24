package offer10_I;

public class DPSolution {
    //时间复杂度：O(n)    空间复杂度：O(1)
    public int fib(int n) {
        int a = 0, b = 1, sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
