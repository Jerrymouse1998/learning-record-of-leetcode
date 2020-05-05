package question154;

public class DichotomySolution {
    //时间复杂度：O(n)	最坏情况，所有元素都相同，只要区间右边界在步进，退化到O(n)。
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] == nums[right]) {
                //剔除一个重复元素
                right--;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            }
        }
        return nums[left];
    }
}
