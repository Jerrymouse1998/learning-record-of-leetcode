package question1;

import java.util.HashMap;
import java.util.Map;

public class HashMapSolution {
//时间复杂度O(n)
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map =new HashMap<Integer,Integer>();

        for (int i=0;i<nums.length;i++){
            int temp=target-nums[i];
//          所需要的temp是否在map中，如果在就返回map中temp值对应的value(即temp值对应的下标)和i。
            if (map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }
//          temp如果不在map中，就将nums[i]作为key、下标i作为value放入map中
            map.put(nums[i],i);
        }
        throw new IndexOutOfBoundsException("no twoSum result!");
    }
}
