package question912;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {
    /*
        桶排序(每个桶的排序方法，暂时先用API进行排序)
        平均/最好时间复杂度：O(n+k)
        最坏时间复杂度：取决于桶内的排序算法，例如采用了快排，那么最坏就是O(n^2)
        空间复杂度：O(n+k)
        稳定
     */
    public int[] sortArray(int[] nums) {
        //定义一个桶的大小
        int SIZE = 100;
        //找到最大最小值,即元素范围
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int e : nums) {
            min = Math.min(min, e);
            max = Math.max(max, e);
        }
        int bias = 0-min;
        int span = max - min + 1;
        //计算桶的数量
        int bucketNum = (span % SIZE == 0) ? (span / SIZE) : (span / SIZE + 1);
        //遍历将元素放入对应的桶中
        List<Integer>[] buckets=new List[bucketNum];
        for (int e : nums) {
            int idx=(e+bias)/SIZE;
            if (buckets[idx]==null)buckets[idx]=new ArrayList<>();
            buckets[idx].add(e);
        }
        //将每个桶中的元素进行排序后放入nums
        int idx=0;
        for (List<Integer> bucket : buckets) {
            if (bucket != null) {
                bucket.sort(null);//默认升序,内部是TimSort
                //排序后放回nums
                for (Integer e : bucket) {
                    nums[idx++]=e;
                }
            }
        }
        return nums;
    }
}
