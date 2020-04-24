package offer51;

public class BFSolution {
    //时间复杂度：O(n^2)
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) count++;
            }
        }
        return count;
    }
}
