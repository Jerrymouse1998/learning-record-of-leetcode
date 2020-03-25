package sort;

public class ShellSort {

    /*
        希尔排序
        时间复杂度：O(n^1.3)  亚二次时间运行
        空间复杂度：O(1)
        不稳定
     */
    public static void shellSort(int[] arr) {
        int len = arr.length;
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int temp = arr[i];
                int preIdx = i - gap;
                while (preIdx >= 0 && arr[preIdx] > temp) {
                    arr[preIdx + gap] = arr[preIdx];
                    preIdx -= gap;
                }
                arr[preIdx + gap] = temp;
            }
            gap /= 2;
        }
    }
}
