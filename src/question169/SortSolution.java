package question169;

import java.util.Arrays;

public class SortSolution {
    //时间复杂度：O(nlogn)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
