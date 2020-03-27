package question914;

import java.util.ArrayList;
import java.util.List;

public class BFSolution {
    //时间复杂度：O(n^2)
    public boolean hasGroupsSizeX(int[] deck) {
        //统计数字出现的个数
        int[] counter = new int[10000];
        for (int e : deck) {
            counter[e]++;
        }
        //找到数量最少的卡牌
        int min = 10000;
        List<Integer> values=new ArrayList<>();
        for (int e : counter) {
            if (e > 0) {
                values.add(e);
                min=Math.min(e,min);
            }
        }
        //如果最少的数量小于2，返回false
        if (min<2)return false;
        //遍历[2,min]区间
        for (int x=2;x<=min;x++){
            //如果x不能整除length则跳过
            if (deck.length%x!=0)continue;
            //检查x是否能整除每个数字的数量
            if (isOK(values,x))return true;
        }
        return false;
    }

    private boolean isOK(List<Integer> values, int x) {
        for (int value : values) {
            //如果有不能被x整除的数量就返回false
            if (value%x!=0)return false;
        }
        return true;
    }
}
