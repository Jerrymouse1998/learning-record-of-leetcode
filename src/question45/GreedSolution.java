package question45;

public class GreedSolution {
    //时间复杂度：O(n)
    public int jump(int[] nums) {
        //end当前能跳到的最远点，steps跳的步数，maxposition能跳的最远的距离
        int end=0,steps=0,maxPosition=0;
        //注意是：i<length-1，如果最后一跳最远距离刚好到达终点会导致额外一次steps++
        for (int i = 0; i < nums.length - 1; i++) {
            //在当前可跳的范围内，寻找能跳的最远位置
            maxPosition=Math.max(maxPosition,nums[i]+i);
            //到达当前跳跃最远点
            if (i == end) {
                end=maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
