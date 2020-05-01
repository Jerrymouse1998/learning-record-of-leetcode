package question202;

import java.util.HashSet;

public class HashTableSolution {
    //时间复杂度：O(logn)
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        //还没有证明n是快乐数,也没有发生循环
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = helper(n);
        }
        return n == 1;
    }

    //按位平方求和
    private int helper(int n) {
        int num = 0;
        while (n > 0) {
            int temp = n % 10;
            num += temp * temp;
            n /= 10;
        }
        return num;
    }
}
