package question33;

public class Solution {
    public static void main(String[] args) {
        int nums[]={1,3,4,6,7,9,10};
        System.out.println(new Solution().search(nums,3));
    }

    public int search(int[] nums, int target) {
        if (nums==null||nums.length==0)return -1;
        int start=0,end=nums.length-1;
//        开始二分
        while (start<=end){
//            得到中间元素的下标
            int mid=start+(end-start)/2;
//            如果中间元素等于target，返回mid
            if (target==nums[mid])return mid;
//            如果中间元素大于第一个元素，说明前半部分是有序的,注意这里是>=
            if (nums[mid]>=nums[start]){
                if (target>=nums[start]&&target<nums[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else {//否则就是后半部分是有序的
                if (target<=nums[end]&&target>nums[mid]){
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}
