package question55;

public class GreedSolution {
    //时间复杂度：O(n)
    public boolean canJump(int[] nums) {
        if (nums==null||nums.length==0)return true;
        //end当前跳跃范围，maxPosition记录当前跳跃范围内下一跳最远的位置
        int end=0,maxPosition=0;
        for (int i = 0; i < nums.length-1; i++) {
            //记录当前范围内下一跳最远的位置
            maxPosition=Math.max(maxPosition,nums[i]+i);
            //走到当前跳跃最远点
            if (i==end){
                //跳到最远的位置
                end=maxPosition;
            }
        }
        return end>=nums.length-1;
    }
}
