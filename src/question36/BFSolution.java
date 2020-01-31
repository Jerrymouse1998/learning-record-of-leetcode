package question36;

import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;

import java.util.HashSet;
import java.util.Set;

public class BFSolution {
    public boolean isValidSudoku(char[][] board) {
        if (board==null||board.length<9)return false;
        Set<Character> set=new HashSet<>();
        //遍历每一行判断是否有重复
        for (int i=0;i<9;i++){
            //遍历完一行之后清空set
            set.clear();
            for (int j=0;j<9;j++){
                //如果这个元素是1-9，则判断是否重复元素
                if (board[i][j]>='1'&&board[i][j]<='9'){
                    if (set.contains(board[i][j])){
                        return false;
                    }else {
                        set.add(board[i][j]);
                    }
                }
            }
        }
        //遍历每一列判断是否有重复元素
        for (int j=0;j<9;j++){
            set.clear();
            for (int i=0;i<9;i++){
                if (board[i][j]>='1'&&board[i][j]<='9'){
                    if (set.contains(board[i][j])){
                        return false;
                    }else {
                        set.add(board[i][j]);
                    }
                }
            }
        }
        //遍历每一个3*3矩阵是否有重复元素
        for (int k=0;k<3;k++){
            for (int m=0;m<3;m++){
                set.clear();
                for (int i=0;i<3;i++){
                    for (int j=0;j<3;j++){
                        if (board[i+(3*m)][j+(3*k)]>='1'&&board[i+(3*m)][j+(3*k)]<='9'){
                            if (set.contains(board[i+(3*m)][j+(3*k)])){
                                return false;
                            }else {
                                set.add(board[i+(3*m)][j+(3*k)]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
