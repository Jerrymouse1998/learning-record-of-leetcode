package question210;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    //时间复杂度：O(E+V)	边的数量 E ，节点数量 V。两次遍历邻接表
    //空间复杂度：O(E+V)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //保存每个节点的入度
        int[] inDegree = new int[numCourses];
        //保存每个节点的后继邻接节点
        List<Integer>[] nextAdjacency = new List[numCourses];
        //预处理
        for (int i = 0; i < numCourses; i++) nextAdjacency[i] = new LinkedList<>();
        for (int[] temp : prerequisites) {
            inDegree[temp[0]]++;
            nextAdjacency[temp[1]].add(temp[0]);
        }
        //广搜队列
        Queue<Integer> queue = new LinkedList<>();
        //入度为 0 的节点入队
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        //保存出队节点序列 和 数量
        int[] res = new int[numCourses];
        int count = 0;
        //广搜
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            res[count++] = poll;
            //遍历出队节点的所有后继邻接节点
            for (int next : nextAdjacency[poll]) {
                //后继邻接节点入度-1
                inDegree[next]--;
                //后继邻接节点入度为 0 则入队
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        //是否有环
        return count == numCourses ? res : new int[0];
    }
}
