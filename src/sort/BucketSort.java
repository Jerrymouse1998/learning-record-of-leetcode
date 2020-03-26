package sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    /*
        桶排序(每个桶的排序方法，暂时先用API直接排序)
        平均/最好时间复杂度：O(n+k)
        最坏时间复杂度：O(n^2)
        空间复杂度：O(n+k)
        稳定
     */
    public static void BucketSort(int[] arr,int bucketSize){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }
        System.out.println(bucketArr.toString());
    }
}
