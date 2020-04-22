package question118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //时间复杂度：O(numRows^2)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        //第一行是1
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            //上一行
            List<Integer> pre = res.get(i - 1);
            //当前行
            List<Integer> curr = new ArrayList<>();
            //行首是1
            curr.add(1);
            //填充当前行中间元素
            for (int j = 1; j < i; j++) {
                curr.add(pre.get(j - 1) + pre.get(j));
            }
            //行尾是1
            curr.add(1);
            res.add(curr);
        }
        return res;
    }
}
