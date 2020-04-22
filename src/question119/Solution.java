package question119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //时间复杂度：O(numIndex^2)
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        //一行一行计算
        for (int i = 1; i <= rowIndex; i++) {
            //逆序计算每个值
            for (int j = i - 1; j > 0; j--) {
                curr.set(j, curr.get(j - 1) + curr.get(j));
            }
            //行尾的1
            curr.add(1);
        }
        return curr;
    }
}
