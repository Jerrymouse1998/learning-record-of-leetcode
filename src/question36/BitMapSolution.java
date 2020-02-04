package question36;

public class BitMapSolution {

    public boolean isValidSudoku(char[][] board) {
        int[] map=new int[9];
        for (int row=0;row<9;row++){
            for (int col=0;col<9;col++){
                char c = board[row][col];
                if (c!='.'){
                    //0-8位表示行号，9-17位表示列号，18-26位表示第几个子数独
                    int index=1<<(0+row)|1<<(9+col)|1<<(18+row/3*3+col/3);
                    //按位与等于0说明该数字不曾在同一行、列、子数独中出现过
                    if ((map[c-'0'-1]&index)==0){
                        //按位或将数字加入数组对应元素
                        map[c-'0'-1]|=index;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
