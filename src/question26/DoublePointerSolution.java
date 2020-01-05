package question26;

public class DoublePointerSolution {

//    时间复杂度：O(n)
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        if (nums==null||len==0)return 0;
        int i=0;
        for (int j=1;j<len;j++){
//            如果不相等,则先移动i指针再让j指向的元素覆盖此时i指向的元素
            if (nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
