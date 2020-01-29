package question35;


public class DichotomySolution {
//    时间复杂度：O(logn)
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid] == target) {
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if (nums[mid]<target){
                left=mid+1;
            }
        }
        return left;
    }
}
