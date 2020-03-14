package question300;

import java.util.TreeSet;

public class TreeSetSolution {
    //时间复杂度：O(n^2)
    public int lengthOfLIS(int[] nums) {
        if (nums==null||nums.length==0)return 0;
        TreeSet<Integer> set=new TreeSet<>();
        for (int num : nums) {
            Integer x = set.ceiling(num);
            if (x != null) {
                set.remove(x);
            }
            set.add(num);
        }
        return set.size();
    }
}
