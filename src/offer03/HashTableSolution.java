package offer03;

import java.util.HashSet;
import java.util.Set;

public class HashTableSolution {
    //时间复杂度：O(n)    空间复杂度：O(n)
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }
}
