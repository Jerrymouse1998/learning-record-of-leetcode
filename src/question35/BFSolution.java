package question35;

public class BFSolution {
    //时间复杂度:O(n)
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if (nums[i]==target||nums[i]>target)return i;
        }
        return nums.length;
    }
}
