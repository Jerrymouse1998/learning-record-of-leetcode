package question134;

public class GreedySolution {
    //时间复杂度：O(n)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //起点
        int start = 0;
        //start为起点,[start -> i]的剩余油量
        int remain = 0;
        //0为起点,[0 -> start]的剩余油量
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            //计算当前[start -> i]的剩余油量
            remain += gas[i] - cost[i];
            //说明从当前的start出发到i,行不通
            if (remain < 0) {
                //更新起点
                start = i + 1;
                //当前[start -> i]的剩余油量,汇总进[0 -> start]的剩余油量
                total += remain;
                //重新计算新起点,[start -> i]的剩余油量
                remain = 0;
            }
        }
        //检查最终的start是否可行
        return remain + total >= 0 ? start : -1;
    }
}
