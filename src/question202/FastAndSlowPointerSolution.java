package question202;

public class FastAndSlowPointerSolution {
    //时间复杂度：O(logn)
    public boolean isHappy(int n) {
        int slow = n, fast = helper(n);
        while (fast != 1 && slow != fast) {
            slow = helper(slow);
            fast = helper(helper(fast));
        }
        return fast == 1;
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
