package question48;

public class TransposedMatrixSolution {
    //时间复杂度:O(n^2)
    public void rotate(int[][] matrix) {
        if (matrix==null)return;
        //转置矩阵
        for (int i=0;i<matrix.length;i++){
            for (int j=i;j<matrix[i].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //列对换
        for (int i=0;i<matrix.length/2;i++){
            for (int j=0;j<matrix.length;j++){
                int temp=matrix[j][i];
                matrix[j][i]=matrix[j][matrix.length-1-i];
                matrix[j][matrix.length-1-i]=temp;
            }
        }
    }
}
