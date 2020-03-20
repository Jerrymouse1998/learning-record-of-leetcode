package offer40;

import java.util.PriorityQueue;
import java.util.Queue;

public class HeapSolution {
    //时间复杂度：O(nlogk)
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k<1)return new int[0];
        //优先队列默认是小顶堆，传一个Comparator接口实现大顶堆
        Queue<Integer> heap=new PriorityQueue<>(k,(e1,e2)->e2-e1);
        //遍历数组
        for (int e : arr) {
            //如果堆中不满k或者当前元素小于堆顶元素(最大的)
            if (heap.size()<k||heap.peek()>e){
                heap.offer(e);
            }
            //堆中元素大于k，移除堆顶元素
            if (heap.size() > k) {
                heap.poll();
            }
        }
        //将堆中元素加入结果集
        int[] res=new int[k];
        int i=0;
        for (Integer e : heap) {
            res[i++]=e;
        }
        return res;
    }
}
