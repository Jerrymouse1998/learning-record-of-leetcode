package question974;

import java.util.HashMap;

public class BFSolution {
    //间复杂度：O(n^2)
    // 空间复杂度：O(n)	map 可以使用数组完成 下标 x 和 值保存前缀和形成映射。
    public int subarraysDivByK(int[] A, int K) {
        //保存[x,前缀和]映射
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 0);
        //求前缀和
        for (int x = 1; x <= A.length; x++) {
            int sum = prefix.get(x - 1) + A[x - 1];
            prefix.put(x, sum);
        }
        int count = 0;
        for (int i = 0; i <= A.length; i++) {
            for (int j = i + 1; j <= A.length; j++) {
                if ((prefix.get(j) - prefix.get(i)) % K == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
