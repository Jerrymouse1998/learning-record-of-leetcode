package question34;

public class DichotomyAndLinear {
    public int[] searchRange(int[] nums, int target) {
        int[] result={-1,-1};
        int left=0,right=nums.length-1;
        //先二分法找到target的下标
        while (left<=right){
            int mid=(left+right)/2;
            //如果找到target的下标mid，就以mid为中心分别向左向右线性查找
            if (nums[mid]==target){
                int left_key=mid,right_key=mid;
                //向左向右线性查找，直至找到不等于target
                while (left_key>=0&&nums[left_key]==target)left_key--;
                while (right_key<nums.length&&nums[right_key]==target)right_key++;
                //保存最左和最右的target值的下标
                result[0]=left_key+1;
                result[1]=right_key-1;
                //终止二分法
                break;
            }else if (nums[mid]<target){
                left=mid+1;
            }else if (nums[mid]>target){
                right=mid-1;
            }
        }
        return result;
    }
}
