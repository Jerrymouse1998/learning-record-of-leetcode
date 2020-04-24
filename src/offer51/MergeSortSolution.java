package offer51;

import java.util.Arrays;

public class MergeSortSolution {

    int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums);
        return count;
    }

    public int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0;
        for (int idx = 0; idx < result.length; idx++) {
            if (i >= left.length) {
                result[idx] = right[j++];
            } else if (j >= right.length) {
                result[idx] = left[i++];
            } else if (left[i] <= right[j]) {
                result[idx] = left[i++];
            } else {
                count += left.length - i;
                result[idx] = right[j++];
            }
        }
        return result;
    }

}
