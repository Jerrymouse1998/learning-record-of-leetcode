package question912;

public class ShellSort {

    /*
        希尔排序
        平均/最坏/最好时间复杂度：O(nlogn)  亚二次时间运行
        空间复杂度：O(1)
        不稳定
     */
    public static void shellSort(int[] arr) {
        int len = arr.length;
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int curr = arr[i],preIdx = i - gap;
                while (preIdx >= 0 && arr[preIdx] > curr) {
                    arr[preIdx + gap] = arr[preIdx];
                    preIdx -= gap;
                }
                arr[preIdx + gap] = curr;
            }
            gap /= 2;
        }
    }
}
