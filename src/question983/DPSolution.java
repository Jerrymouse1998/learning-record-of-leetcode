package question983;

public class DPSolution {
    //时间复杂度：O(maxDay-minDay)
    public int mincostTickets(int[] days, int[] costs) {
        int minDay = days[0], maxDay = days[days.length - 1];
        int[] dp = new int[maxDay + 31];
        //days 数组索引
        int i = days.length - 1;
        //计算 [minDay,maxDay] 区间内的每一天
        for (int day = maxDay; day >= minDay; day--) {
            //第 day 天需要旅行
            if (day == days[i]) {
                //三种方案
                dp[day] = Math.min(costs[0] + dp[day + 1],
                        Math.min(costs[1] + dp[day + 7], costs[2] + dp[day + 30]));
                // days[i]计算完毕
                i--;
            } else {
                //第 day 天不需要旅行 dp[day]=0+dp[day + 1]
                dp[day] = dp[day + 1];
            }
        }
        return dp[minDay];
    }
}
