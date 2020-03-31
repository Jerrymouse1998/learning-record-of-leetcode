package question912;

public class CountingSort {
    /*
        计数排序
        平均/最好/最坏时间复杂度：O(n+k)    n是arr长度，k是范围
        空间复杂度：O(k)
        稳定
     */
    public static void countingSort(int[] arr){
        if (arr==null||arr.length<2)return;
        //找到数组中最大、最小，以及两者之间的偏差值
        int min=arr[0],max=arr[0],bias=0;
        for (int e : arr) {
            if (e>max)max=e;
            if (e<min)min=e;
        }
        bias=0-min;
        //计数
        int[] counter=new int[max-min+1];
        for (int e : arr) {
            counter[e+bias]++;
        }
        //将计数器中的元素依次取出，即可完成排序
        int counter_idx=0,arr_idx=0;
        while (counter_idx < counter.length) {
            if (counter[counter_idx] != 0) {
                counter[counter_idx]--;
                arr[arr_idx++]=counter_idx-bias;
            }else {
                counter_idx++;
            }
        }
    }
}
