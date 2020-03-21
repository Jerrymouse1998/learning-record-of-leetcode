package question365;

public class BézoutSolution {
    //时间复杂度：O(logMax(x,y))
    public boolean canMeasureWater(int x, int y, int z) {
        if (z==0)return true;
        if (x+y<z)return false;
        //求x，y的最大公约数
        int d=gcd(x,y);
        return z%d==0;
    }

    private int gcd(int x, int y) {
        if (y==0)return x;
        return gcd(y,x%y);
    }
}
