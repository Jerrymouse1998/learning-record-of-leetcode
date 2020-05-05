package question153;

public class DichotomySolution {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        //left == right 时停止搜索,此时左闭右闭区间内剩余一个元素
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] > nums[right]) {
                //此时 mid 一定不是最小值,所以从搜索区间内删除
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
