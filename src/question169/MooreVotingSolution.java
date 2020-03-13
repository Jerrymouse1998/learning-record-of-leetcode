package question169;

public class MooreVotingSolution {
    //时间复杂度：O(n)
    public int majorityElement(int[] nums) {
        int candidate=nums[0],count=0;
        for (int num : nums) {
            if (num==candidate){
                count++;
            }else {
                count--;
            }
            if (count==0){
                candidate=num;
                count=1;
            }
        }
        return candidate;
    }
}
