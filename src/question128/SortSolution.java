package question128;

import java.util.Arrays;

public class SortSolution {
    //时间复杂度：O(nlogn)
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //排序O(nlogn)
        Arrays.sort(nums);
        int curStreak = 1;
        int longestStreak = 1;
        for (int i = 1; i < nums.length; i++) {
            //跳过重复元素
            if (nums[i] != nums[i - 1]) {
                //计算连续序列长度
                if (nums[i] == nums[i - 1] + 1) {
                    curStreak++;
                } else {
                    longestStreak = Math.max(longestStreak, curStreak);
                    curStreak = 1;
                }
            }
        }
        //求max，防止最后一组连续序列被遗漏
        return Math.max(longestStreak, curStreak);
    }
}
