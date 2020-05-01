package question136;

public class Solution {
    //时间复杂度：O(n) 空间复杂度：O(1)
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans^=num;
        }
        return ans;
    }
}
