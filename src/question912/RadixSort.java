package question912;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {
    /*
        基数排序
        平均/最坏/最好时间复杂度：O(n*k/d)  k是key的总数量，d是最大十进制数的位数
        空间复杂度：O(n+2^d)
        稳定
     */
    public int[] sortArray(int[] nums) {
        // 计算最大最小数
        int max = -1,min = 1;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 求得绝对值最大的数
        max = Math.max(max, -min);
        // 计算绝对值最大的数的位数
        int digits = 0;
        while (max > 0) {
            max /= 10;
            digits++;
        }
        // 建一个包含所有位数的数组
        List<Integer>[] buckets = new List[19];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        // 对十进制每一位进行基数排序
        int pos,cur;
        for (int i = 0, mod = 1; i < digits; i++, mod*=10) {
            // 扫描数组将值放入对应的桶
            for (int num : nums) {
                pos = (num / mod) % 10;
                buckets[pos+9].add(num);
            }
            // 将桶内元素放回到数组里面
            cur = 0;
            for (List<Integer> bucket : buckets) {
                if (bucket!=null) {
                    for (Integer integer : bucket) {
                        nums[cur++] = integer;
                    }
                    // 将桶清空
                    bucket.clear();
                }
            }
        }
        return nums;
    }

}
