package question169;

import java.util.HashMap;
import java.util.Map;

public class HashTableSolution {
    //时间复杂度：O(n)
    public int majorityElement(int[] nums) {
        //统计数字出现次数
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            Integer value = map.getOrDefault(num, 0);
            map.put(num,value+1);
        }
        //遍历map，打擂台找到多数元素
        int ans=0,maxNum=0;
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            if (en.getValue()>maxNum){
                ans=en.getKey();
                maxNum=en.getValue();
            }
        }
        return ans;
    }
}
