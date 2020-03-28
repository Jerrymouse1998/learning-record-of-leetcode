package question81;

public class DichotomySolution {

    public boolean search(int[] nums, int target) {
        int start=0,end=nums.length-1;
        while (start <= end) {
            int mid=start+(end-start)/2;
            //找到target
            if (nums[mid]==target)return true;
            //无法判断有序的一半，忽略重复项，继续搜索
            if (nums[mid]==nums[start]){
                start++;
                continue;
            }
            //可以判断有序的一半和NO.33方法一样，二分法缩小搜搜区间
            if (nums[mid]>nums[start]){
                if (target<nums[mid]&&target>nums[start])end=mid-1;
                else start=mid+1;
            }else {
                if (target>nums[mid]&&target<=nums[end])start=mid+1;
                else end=mid-1;
            }
        }
        return false;
    }
}
