package question912;

public class SelectionSort {
    /*
        选择排序
        平均/最坏/最好时间复杂度：O(n^2)
        空间复杂度：O(1)
        不稳定
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}
