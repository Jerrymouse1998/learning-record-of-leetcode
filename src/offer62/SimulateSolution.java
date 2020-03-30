package offer62;

import java.util.ArrayList;
import java.util.List;

public class SimulateSolution {
    //时间复杂度：O(n^2)	需要删除n-1个元素，删除操作需要O(n)。
    public int lastRemaining(int n, int m) {
        //将0~n-1放入list
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        //逐个移除
        int idx=0;
        while (n > 1) {
            idx=(idx+m-1)%n;
            list.remove(idx);
            n--;
        }
        //最后剩下一个
        return list.get(0);
    }
}
