package sort;

public class BublleSort {
    /*
        冒泡排序
        平均/最坏/最好时间复杂度：O(n^2)
        无论如何都要嵌套循环跑一遍，可以加一个标志，如果已经有序就停止循环，可以将最好时间优化到O(n)
        空间复杂度：O(1)
        稳定
     */
    public static void bublleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
