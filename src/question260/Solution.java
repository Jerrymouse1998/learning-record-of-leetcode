package question260;

public class Solution {
    //时间复杂度：O(n)    空间复杂度：O(1)
    public int[] singleNumber(int[] nums) {
        //得到 a^b
        int n = 0;
        for (int num : nums) {
            n ^= num;
        }
        //得到n中任意一位1的位置
        int h = 1;
        while ((h & n) == 0) {
            h <<= 1;
        }
        //分组异或
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & h) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
