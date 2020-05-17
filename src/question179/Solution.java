package question179;

import java.util.Arrays;

public class Solution {
    //时间复杂度：O(nlogn)	取决于排序的时间复杂度。
    //空间复杂度：O(n)
    public String largestNumber(int[] nums) {
        //转换成字符串
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        //自定义排序
        Arrays.sort(strs, (e1, e2) -> {
            String x = e1 + e2;
            String y = e2 + e1;
            return y.compareTo(x);
        });
        //拼接得到结果
        if (strs[0].equals("0")) return "0";
        StringBuilder ans = new StringBuilder();
        for (String str : strs) {
            ans.append(str);
        }
        return ans.toString();
    }
}
