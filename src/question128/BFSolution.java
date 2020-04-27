package question128;

public class BFSolution {
    //时间：O(n^3)
    public int longestConsecutive(int[] nums) {
        int longestStreak = 0;
        //遍历
        for (int num : nums) {
            int cur = num;
            int curStreak = 1;
            //计算num开头的连续序列长度
            while (isContains(nums, cur + 1)) {
                cur++;
                curStreak++;
            }
            //更新最长长度
            longestStreak = Math.max(longestStreak, curStreak);
        }
        return longestStreak;
    }

    private boolean isContains(int[] nums, int num) {
        //遍历
        for (int i : nums) {
            if (i == num) return true;
        }
        return false;
    }
}
