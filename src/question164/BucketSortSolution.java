package question164;

public class BucketSortSolution {
    //时间复杂度：O(n+m)	n 数组长度、m是桶数量
    //空间复杂度：O(m)

    //桶结构,桶内只关心最大值、最小值
    class Bucket {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        //找到最小值、最大值
        int max = 0, min = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        //计算桶大小,桶数量至少一个
        int bucketSize = Math.max((max - min) / (nums.length - 1), 1);
        Bucket[] buckets = new Bucket[(max - min) / bucketSize + 1];
        //入桶,每个桶只关心桶内的最大值和最小值
        for (int i = 0; i < nums.length; i++) {
            int idx = (nums[i] - min) / bucketSize;
            if (buckets[idx] == null) buckets[idx] = new Bucket();
            buckets[idx].max = Math.max(nums[i], buckets[idx].max);
            buckets[idx].min = Math.min(nums[i], buckets[idx].min);
        }
        //前一个桶的 max
        int preMax = -1;
        //最大间隔
        int maxGap = 0;
        for (int i = 0; i < buckets.length; i++) {
            //桶不为空,并且不是第一个桶
            if (buckets[i] != null && preMax != -1) {
                //桶之间的间隔
                maxGap = Math.max(maxGap, buckets[i].min - preMax);
            }
            //记录前一个桶的 max
            if (buckets[i] != null) {
                preMax = buckets[i].max;
            }
        }
        return maxGap;
    }

}
