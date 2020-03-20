package offer40;

import java.util.Arrays;

public class SortAPISolution {
    //时间复杂度：O(nlogn)
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=arr[i];
        }
        return res;
    }
}
