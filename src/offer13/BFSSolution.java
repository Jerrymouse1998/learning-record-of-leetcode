package offer13;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFSSolution {
    //时间复杂度：O(mn)
    public int movingCount(int m, int n, int k) {
        //队列保存坐标
        Queue<int[]> queue=new ArrayDeque<>();
        //标记数组
        boolean[][] visited=new boolean[m][n];
        //广搜
        queue.add(new int[]{0,0});
        int count=0;
        visited[0][0]=true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            count++;
            //向下、向右寻找符合要求的位置入队并标记访问状态
            //不越界 并且 数位和小于等于k 并且 未访问过
            if (poll[0] + 1 < m
                    && sums(poll[0] + 1, poll[1]) <= k
                    &&!visited[poll[0]+1][poll[1]]){
                queue.add(new int[]{poll[0]+1,poll[1]});
                visited[poll[0]+1][poll[1]]=true;
            }
            if (poll[1] + 1 < n
                    && sums(poll[0], poll[1] + 1) <= k
                    &&!visited[poll[0]][poll[1] + 1]){
                queue.add(new int[]{poll[0],poll[1]+1});
                visited[poll[0]][poll[1]+1]=true;
            }
        }
        return count;
    }
    //计算数位和
    public int sums(int x,int y){
        int ans=0;
        while (x != 0) {
            ans+=x%10;
            x/=10;
        }
        while (y != 0) {
            ans+=y%10;
            y/=10;
        }
        return ans;
    }
}
