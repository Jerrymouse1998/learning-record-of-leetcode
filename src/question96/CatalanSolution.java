package question96;

public class CatalanSolution {
    //时间复杂度：O(n)
    public int numTrees(int n) {
        long C=1;
        for (int i = 0; i < n; i++) {
            C=2*C*(2*i+1)/(i+2);
        }
        return (int)C;
    }
}
