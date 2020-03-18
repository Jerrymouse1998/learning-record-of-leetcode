package question70;

public class DFSSolution {

    public int climbStairs(int n) {
        switch (n){
            case 1:return 1;
            case 2:return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }
}
