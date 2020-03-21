package offer40;

public class DivideAndConquerSolution {
    //时间复杂度的分析方法和快速排序类似。由于快速选择只需要递归一边的数组，时间复杂度小于快速排序。
    // 期望时间复杂度为O(n)，最坏情况下的时间复杂度为O(n^2)
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        if (arr.length <= k) return arr;
        //不断划分数组并调整
        partitionArray(arr, 0, arr.length-1, k);
        //经过划分调整之后数组前k个数已经是最小的k个
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=arr[i];
        }
        return res;
    }

    private void partitionArray(int[] arr, int low, int high, int k) {
        //和快排的partition一样
        if (low<high) {
            int idx = partition(arr, low, high);
            //idx==k，idx左侧部分是最小TopK
            if (idx == k) {
                return;
            } else if (k < idx) {
                partitionArray(arr, low, idx - 1, k);
            } else {
                partitionArray(arr, idx + 1, high, k);
            }
        }
    }
    //partitoin操作和快排一样
    private int partition(int[] arr, int low, int high) {
        int l=low,h=high,temp=arr[low];
        while (l < h) {
            while (l<h&&arr[h]>=temp)h--;
            if (l<h)arr[l++]=arr[h];
            while (l<h&&arr[l]<=temp)l++;
            if (l<h)arr[h--]=arr[l];
        }
        arr[l]=temp;
        return l;
    }

}
