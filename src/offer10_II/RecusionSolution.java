package offer10_II;

public class RecusionSolution {
    //暴力法 时间复杂度：O(2^n)
    public int numWays(int n) {
        switch (n) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
        }
        return (numWays(n - 1) + numWays(n - 2)) % 1000000007;
    }
}
