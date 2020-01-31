package question36;


public class OnceSolution {
    public boolean isValidSudoku(char[][] board) {
        //用三个二维数组分别分别记录9行、9列、9个子数独中的元素，用来判断是否重复
        int[][] rows=new int[9][9];
        int[][] cols=new int[9][9];
        int[][] boxes=new int[9][9];
        //遍历数独中每个元素
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                char c = board[i][j];
                //如果被遍历元素是数字，则添加到其对应的数组中进行记录
                if (c>='1'&&c<='9'){
                    int box_index=(i/3)*3+j/3;
                    rows[i][c-'0'-1]++;
                    cols[j][c-'0'-1]++;
                    boxes[box_index][c-'0'-1]++;
                    //判断是否出现重复
                    if (rows[i][c-'0'-1]>1||cols[j][c-'0'-1]>1||boxes[box_index][c-'0'-1]>1)return false;
                }
            }
        }
        return true;
    }
}
