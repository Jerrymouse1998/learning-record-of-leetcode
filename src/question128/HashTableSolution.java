package question128;

import java.util.HashSet;
import java.util.Set;

public class HashTableSolution {
    //时间复杂度：O(n)    循环嵌套并不是O(n^2)
    public int longestConsecutive(int[] nums) {
        //nums存入HashSet
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for (Integer num : set) {
            //num-1不存在的num作为序列的开头
            if (!set.contains(num - 1)) {
                int cur = num;
                int curStreak = 1;
                //num+1是否存在
                while (set.contains(cur + 1)) {
                    cur++;
                    curStreak++;
                }
                longestStreak = Math.max(longestStreak, curStreak);
            }
        }
        return longestStreak;
    }
}
