package question1248;

import java.util.HashMap;

public class HashTableSolution {
    //时间复杂度：O(n) 两次遍历	空间：O(n)
    public int numberOfSubarrays(int[] nums, int k) {
        //奇数为1，偶数为0
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (nums[i] & 1) == 1 ? 1 : 0;
        }
        //和为K的子数组
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
