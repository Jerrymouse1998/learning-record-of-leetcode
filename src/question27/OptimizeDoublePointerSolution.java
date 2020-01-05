package question27;

public class OptimizeDoublePointerSolution {

    public int removeElement(int[] nums, int val) {
        if (nums==null||nums.length==0)return 0;
        int i=0,j=nums.length;
        while (i<j){
            if (nums[i]==val){
                nums[i]=nums[j-1];
                j--;
            }else {
                i++;
            }
        }
        return j;
    }
}
