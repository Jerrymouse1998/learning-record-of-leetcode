package question27;

public class DoublePointerSolution {

    public int removeElement(int[] nums, int val) {
        if (nums==null||nums.length==0)return 0;
        int i=0;
        for (int j=0;j<nums.length;j++){
//            如果j号指针不等于val，就先将j号元素"覆盖"i号元素再移动i指针
            if (nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
}
