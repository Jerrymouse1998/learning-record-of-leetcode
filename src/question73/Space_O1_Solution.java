package question73;

public class Space_O1_Solution {
    //时间复杂度：O(mn) 空间复杂度：O(1)
    public void setZeroes(int[][] matrix) {
        boolean flag_0row = false, flag_0col = false;
        int m = matrix.length, n = matrix[0].length;
        //检查第一行、第一列是否有0,
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flag_0col = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                flag_0row = true;
                break;
            }
        }
        //遍历除了第一列和第一行之外的其余所有元素
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
            }
        }
        //再次遍历除了第一列和第一行之外的其余所有元素
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        //检查flag
        if (flag_0row) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (flag_0col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
