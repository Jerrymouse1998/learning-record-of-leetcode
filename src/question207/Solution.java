package question207;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //时间复杂度：O(E+V)	边的数量 E ，节点数量 V。两次遍历邻接表
    //空间复杂度：O(E+V)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;
        //保存每个节点的入度
        int[] inDegree = new int[numCourses];
        //保存每个节点的下一个后继邻接节点
        HashSet<Integer>[] nextAdjacency = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) nextAdjacency[i] = new HashSet<>();
        //预处理
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
        //开始广搜,记录出过队的节点数量
        int count = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            count++;
            //遍历出队节点的所有后继邻接节点
            for (int next : nextAdjacency[poll]) {
                //减少后继节点的一条入度
                inDegree[next]--;
                //如果后继节点的入度为 0 则入队
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        //如果存在环,则 count<numCourses
        return count == numCourses;
    }
}
