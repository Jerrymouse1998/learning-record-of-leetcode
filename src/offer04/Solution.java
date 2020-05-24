package offer04;

public class Solution {
    //时间复杂度：O(m+n) m行，n列    空间复杂度：O(1)
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] == target) {
                return true;
            }
        }
        return false;
    }
}
