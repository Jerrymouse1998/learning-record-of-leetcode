package question31;

public class Solution {

    //    一次遍历，时间复杂度：O(n)，在最坏的情况下，只需要对整个数组进行两次扫描
    public void nextPermutation(int[] nums) {
        //逆序找到第一个非递增元素nums[i]
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //如果nums本身非递减序列，逆序找到nums[i]元素右边的递减序列中第一个大于nums[i]的元素
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            //交换nums[i]和nums[j]
            swap(nums, i, j);
        }
        //最后翻转nums[i]右边的元素序列，得到参数数组nums的下一个更大的排列
        reverse(nums, i + 1);
    }

    //    从start号索引开始翻转nums数组元素
    public void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    //    交换nums数组的i和j号索引元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
