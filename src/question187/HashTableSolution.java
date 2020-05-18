package question187;

import java.util.*;

public class HashTableSolution {
    //空间复杂度：O(n)
    //时间复杂度：O(n)
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String temp = s.substring(i, i + 10);
            if (set.contains(temp)) {
                res.add(temp);
            } else {
                set.add(temp);
            }
        }
        return new ArrayList<>(res);
    }
}
