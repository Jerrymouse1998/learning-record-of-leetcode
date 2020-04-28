package offer56;

public class Solution {
    //时间复杂度：O(n)   空间复杂度：O(1)
    public int[] singleNumbers(int[] nums) {
        //得到a^b
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        //拿到res任意不为0的位
        int h = 1;
        while ((h & res) == 0) {
            h <<= 1;
        }
        //分组,分别进行异或
        int a = 0, b = 0;
        for (int num : nums) {
            if ((h & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
