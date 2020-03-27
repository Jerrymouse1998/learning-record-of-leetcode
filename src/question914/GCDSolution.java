package question914;

public class GCDSolution {
    //时间复杂度：O(nlogn)    n是卡牌数量。求GCD时间logn。
    public boolean hasGroupsSizeX(int[] deck) {
        //计数
        int[] counter = new int[10000];
        for (int e : deck) {
            counter[e]++;
        }
        //求GCD
        int x = 0;
        for (int value : counter) {
            if (value > 0) {
                if (x==0)x=value;
                else x=gcd(x,value);
            }
        }
        return x>=2;
    }

    private int gcd(int a, int b) {
        return a==0?b:gcd(b%a,a);
    }
}
