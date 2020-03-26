package sort;

public class HeapSort {
    /*
        堆排序
        平均/最坏/最好时间复杂度：O(nlogn)
        空间复杂度：O(1)
        不稳定
     */

    //无序区的长度
    static int len;

    public static void heapSort(int[] arr) {
        len = arr.length;
        if (len < 2) return;
        //构建大顶堆
        buildHeap(arr);
        while (len > 0) {
            //将堆顶放到最后一个元素，找到最大值
            swap(arr, 0, len - 1);
            //缩小无序区，对无序区重新调整为大顶堆
            len--;
            adjustHeap(arr, 0);
        }
    }

    public static void buildHeap(int[] arr) {
        //从最后一个非叶子节点逐步向上构建大顶堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i);
        }
    }

    public static void adjustHeap(int[] arr, int i) {
        int maxIdx = i;
        //找到左右子树中大于父节点的最大的元素的下标
        if (i * 2 + 1 < len && arr[i * 2 + 1] > arr[maxIdx]) {
            maxIdx = i * 2 + 1;
        }
        if (i * 2 + 2 < len && arr[i * 2 + 2] > arr[maxIdx]) {
            maxIdx = i * 2 + 2;
        }
        //如果父节点不是最大值，交换父节点和左右子树最大值的位置，并继续递归调整移动之后的父节点
        if (maxIdx != i) {
            swap(arr, i, maxIdx);
            adjustHeap(arr, maxIdx);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
