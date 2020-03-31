package question912;

public class InsertionSort {
    /*
        插入排序
        平均/最坏时间复杂度：O(n^2)
        最好时间复杂度：O(n)
        空间复杂度：O(1)
        稳定
     */
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int curr = arr[i + 1], preIdx = i;
            while (preIdx >= 0 && arr[preIdx] > curr) {
                arr[preIdx + 1] = arr[preIdx];
                preIdx--;
            }
            arr[preIdx + 1] = curr;
        }
    }
}
