package question1248;

public class SlidingWindowSolution {
    //时间复杂度：O(n)最坏情况也是两次遍历。 空间：O(n)
    public int numberOfSubarrays(int[] nums, int k) {
        int oddsNum = 0, count = 0;
        //记录奇数元素索引
        int[] odds = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                odds[++oddsNum] = i;
            }
        }
        //左右边界
        odds[0] = -1;
        odds[oddsNum + 1] = nums.length;
        //包含K个奇数的窗口区间[odds[i],odds[i+k]]
        for (int i = 1; i + k < oddsNum + 2; i++) {
            count += (odds[i] - odds[i - 1]) * (odds[i + k] - odds[i + k - 1]);
        }
        return count;
    }
}
