package question213;

public class DPSolution {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        //分割成两个偷窃区间
        return Math.max(helper(nums, 0, nums.length - 2),
                helper(nums, 1, nums.length - 1));
    }
    //动态规划
    private int helper(int[] nums, int start, int end) {
        if (nums.length == 0) return 0;
        int pre = 0, cur = nums[start];
        for (int i = start + 1; i <= end; i++) {
            int temp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = temp;
        }
        return cur;
    }
}
