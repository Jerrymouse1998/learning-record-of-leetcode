package question54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //时间复杂度：O(n)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        if (matrix==null||matrix.length==0)return res;
        int row = matrix.length,col=matrix[0].length;
        //计算有多少层
        int count=(Math.min(row,col)+1)/2;
        //当前层
        int curr=0;
        //遍历每一层
        for (;curr<count;curr++){
            //从左向右
            for (int i = curr; i < col - curr; i++) {
                res.add(matrix[curr][i]);
            }
            //从上到下
            for (int i = curr+1; i < row-curr; i++) {
                res.add(matrix[i][col-1-curr]);
            }
            //从右到左
            for (int i = col-1-curr-1; i >= curr&&(row-1-curr!=curr); i--) {
                res.add(matrix[row-1-curr][i]);
            }
            //从下到上
            for (int i = row-1-curr-1; i >= curr+1&&(col-1-curr!=curr); i--) {
                res.add(matrix[i][curr]);
            }
        }
        return res;
    }
}
