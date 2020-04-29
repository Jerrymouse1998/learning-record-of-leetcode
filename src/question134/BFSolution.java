package question134;

public class BFSolution {
    //时间复杂度：O(n^2)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = 0;
        int n = gas.length;
        //每个加油站分别作为起点
        for (int i = 0; i < n; i++) {
            //开始获得起点的所有油
            remain = gas[i];
            //j记录当前走到哪里
            int j = i;
            //当剩余油量足够到达下一站
            while (remain - cost[j] >= 0) {
                //油量-消耗+到达加油站的全部油
                remain = remain - cost[j] + gas[(j + 1) % n];
                //更新当前位置
                j = (j + 1) % n;
                //如果回到起点,则成功走了一圈
                if (j == i) {
                    return i;
                }
            }
        }
        return -1;
    }
}
