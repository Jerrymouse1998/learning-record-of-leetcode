package question74;

public class DichotomySolution {
    //时间复杂度：O(log(r*c))
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int r = matrix.length, c = matrix[0].length;
        int start = 0, end = r * c - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / c][mid % c] == target) {
                return true;
            } else if (matrix[mid / c][mid % c] < target) {
                start = mid + 1;
            } else if (matrix[mid / c][mid % c] > target) {
                end = mid - 1;
            }
        }
        return false;
    }
}
