package question152;

public class DPSolution {
    //时间复杂度：O(n)
    public int maxProduct(int[] nums) {
        int imax = 1, imin = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //当前元素是负数,imax imin 互换
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            //分别记录乘积最大子数组的值 和 乘积最小子数组的值
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            //更新 max
            max = Math.max(max, imax);
        }
        return max;
    }
}
