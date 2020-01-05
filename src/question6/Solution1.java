package question6;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
//  按行排序,再按行读取  时间复杂度：O(n)
    public String convert(String s, int numRows) {
        if (numRows==1) return s;

        List<StringBuilder> list=new ArrayList<>();
        for (int i=0;i<Math.min(s.length(),numRows);i++){
            list.add(new StringBuilder());
        }

        int currentRow=0;
        boolean goingDown=false;
        for (char c : s.toCharArray()) {
            list.get(currentRow).append(c);
            if (currentRow==0||currentRow==numRows-1)goingDown=!goingDown;
            currentRow+=goingDown?1:-1;
        }

        StringBuilder ans=new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            ans.append(stringBuilder);
        }
        return ans.toString();
    }
}
