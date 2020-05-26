package offer17;

public class Solution {
    //时间复杂度：O(10^n)
    public int[] printNumbers(int n) {
        int size = myPow(10, n);
        int[] res = new int[size - 1];
        //打印从 1 到 10^n-1
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    private int myPow(int x, int n) {
        switch (n) {
            case 1:
                return x;
            case 0:
                return 1;
            case -1:
                return 1 / x;
        }
        int half = myPow(x, n / 2);
        int rest = myPow(x, n % 2);
        return half * half * rest;
    }
}
