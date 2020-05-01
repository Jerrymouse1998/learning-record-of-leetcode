package question137;

public class Solution {
    //时间复杂度：O(n)	32次遍历
    public int singleNumber(int[] nums) {
        int res = 0;
        //分别统计每一位上 1 的个数
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                count += (num >> i) & 1;
            }
            //个数取模 3 再还原回原位,最后保存至res
            res ^= (count % 3) << i;
        }
        return res;
    }
}
