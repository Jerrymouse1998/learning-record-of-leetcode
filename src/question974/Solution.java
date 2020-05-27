package question974;

import java.util.HashMap;

public class Solution {
    //时间复杂度：O(n)	空间复杂度：O(n)	map 可替换为数组。
    public int subarraysDivByK(int[] A, int K) {
        //保存 [前缀和余数,余数出现次数] 的映射
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // sum 记录当前前缀和
        int sum = 0, count = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            //计算余数
            int remain = (sum % K + K) % K;
            //余数存在则记录出现次数
            if (map.containsKey(remain)) {
                count += map.get(remain);
            }
            //更新 map
            map.put(remain, map.getOrDefault(remain, 0) + 1);
        }
        return count;
    }
}
