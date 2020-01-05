package question204;

import java.util.Arrays;

public class EratosthenesSieveSolution {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int i = new EratosthenesSieveSolution().countPrimes(666666);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l+":"+i);
    }
//  厄尔拉塞筛法的时间复杂度：O(nloglogn)
    public int countPrimes(int n){
        boolean isPrimes[]=new boolean[n];
//        全部填充为true，假设全部都是质数
        Arrays.fill(isPrimes,true);
//        只需要判断小于sqrt(n)的数是否为质数即可，所以i*i<n
        for (int i=2;i*i<n;i++){
//            这样可以把质数i的整数倍都标记为false，但是仍然存在计算冗余。
//            比如n=25，i=4时算法会标记4×2=8，4×3=12等等数字，
//            但是这两个数字已经被i=2和i=3的2×4和3×4标记了。所以使用j=i*i避免此计算冗余。
            for (int j=i*i;j<n;j+=i){
                isPrimes[j]=false;
            }
        }

        int count=0;
//      统计所有质数，即isPrimes[i]==true的为质数
//        这里要注意从2开始，因为0,1不是质数
        for (int i=2;i<n;i++){
            if (isPrimes[i])count++;
        }
        return count;
    }
}
