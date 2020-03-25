package sort;

public class QuickSort {
    /*
        快速排序
        平均/最好时间复杂度：O(nlogn) 每次分割对基准数排序O(n)，递归深度logn
        最坏退化到：O(n^2)
        空间复杂度：O(logn)
        不稳定
     */
    public static void quickSort(int[] arr, int low, int high) {
        //递归结束条件low==right
        if (low < high) {
            int l = low, h = high, temp = arr[low];
            while (l < h) {
                //逆序找到第一个小于temp的，放到l坑位
                while (l < h && arr[h] >= temp) h--;
                if (l < h) {
                    arr[l] = arr[h];
                    l++;
                }
                //顺序找到第一个大于temp，放到r坑位
                while (l < h && arr[l] <= temp) l++;
                if (l < h) {
                    arr[h] = arr[l];
                    h--;
                }
            }
            //基准数放到最终l==r的坑位
            arr[l] = temp;
            //递归基准数左右部分
            quickSort(arr, low, l - 1);
            quickSort(arr, l + 1, high);
        }
    }
}
