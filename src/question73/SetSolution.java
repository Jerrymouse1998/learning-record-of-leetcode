package question73;

import java.util.HashSet;
import java.util.Set;

public class SetSolution {

    //时间复杂度：O(mn) 空间复杂度：O(m+n）
    public void setZeroes(int[][] matrix) {
        Set<Integer> row=new HashSet<>(),col=new HashSet<>();
        int m = matrix.length,n=matrix[0].length;
        //第一次遍历，统计值为0的元素的行和列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        //第二次遍历，将两个set记录的行列上的元素置为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row.contains(i)||col.contains(j))matrix[i][j]=0;
            }
        }
    }
}
