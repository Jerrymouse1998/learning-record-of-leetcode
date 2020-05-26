package offer21;

public class Solution {
    //时间复杂度：O(n)
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            //顺序找第一个偶数
            while (i<j&&(nums[i]&1)==1)i++;
            //逆序找第一个奇数
            while (i<j&&(nums[j]&1)==0)j--;
            //交换位置
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
