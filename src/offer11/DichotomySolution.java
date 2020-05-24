package offer11;

public class DichotomySolution {
    //最坏时间复杂度：O(n) 元素全部相同
    //平均时间复杂度：O(logn)
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == numbers[right]) {
                right--;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            }
        }
        return numbers[left];
    }
}
