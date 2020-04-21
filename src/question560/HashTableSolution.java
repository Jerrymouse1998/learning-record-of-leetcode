package question560;

import java.util.HashMap;

public class HashTableSolution {
    //时间复杂度：O(n)	空间：O(n)
    public int subarraySum(int[] nums, int k) {
        //初始化
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        //前i项和sum，计数器count
        int sum = 0, count = 0;
        //遍历
        for (int i = 0; i < nums.length; i++) {
            //前i项和
            sum += nums[i];
            //存在
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
