package question162;

public class DichotomySolution {
    //时间复杂度：O(logn)
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] > nums[mid + 1]) {
                //山峰在 [left,mid]
                right = mid;
            } else {
                //山峰在 [mid+1,right]
                left = mid + 1;
            }
        }
        return left;
    }
}
