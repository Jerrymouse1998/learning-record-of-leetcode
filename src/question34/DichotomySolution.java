package question34;

public class DichotomySolution {
    public static void main(String[] args) {
        System.out.println(new DichotomySolution().searchRange(new int[]{5,7,7,8,8,10},8));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result={-1,-1};
        result[0]=searchLeft(nums,target);
        result[1]=searchRight(nums,target);
        return result;
    }
    //查找最左target
    public int searchLeft(int[] nums,int target){
        int left=0,right=nums.length;
        //这里是<而不是<=，因为搜索区间是[0，length)，终止条件是left==right
        while (left<right){
            int mid =(left+right)/2;
            //因为是寻找最左target，所以这里不能直接返回，而是收缩right去锁定左侧边界
            if (nums[mid]==target){
                right=mid;
            }else if (nums[mid]<target){
                left=mid+1;
            }else if (nums[mid]>target){
                //这里是=mid而不是=mid-1，因为搜索区间是左闭右开
                right=mid;
            }
        }
        //如果target比所有数都大，则返回-1
        if (left==nums.length)return -1;
        //终止条件是left==right，所以返回left或者right都可
        return nums[left]==target?left:-1;
    }
    //寻找最右target
    public int searchRight(int[] nums,int target){
        int left=0,right=nums.length;
        //这里是<而不是<=，因为搜索区间是[0，length)
        while (left<right){
            int mid=(left+right)/2;
            //因为是寻找最右target，所以不能直接返回，而是要增大left去锁定左侧边界
            if (nums[mid]==target){
                left=mid+1;
            }else if (nums[mid]>target){
                right=mid;
            }else if (nums[mid]<target){
                left=mid+1;
            }
        }
        if (right==0)return -1;
        //由于每次收紧左侧边界都是left=mid+1（因为搜索区间是左闭右开），所以无论是left还是right都需要-1
        return nums[right-1]==target?right-1:-1;
    }
}
