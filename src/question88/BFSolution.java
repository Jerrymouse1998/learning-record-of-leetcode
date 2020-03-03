package question88;

import java.util.Arrays;

public class BFSolution {
    //时间复杂度：O((m+n)*log(m+n))
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = 0; i < n; i++) {
            A[m+i]=B[i];
        }
        Arrays.sort(A);
    }
}
