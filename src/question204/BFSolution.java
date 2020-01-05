package question204;

public class BFSolution {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int i = new BFSolution().countPrimes(666666);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l+":"+i);
    }
//    时间复杂度O(n^2)
    public int countPrimes(int n){
        int count=0;
        for (int i=2;i<n;i++){
            if (isPrime(i))
                count++;
        }
        return count;
    }

    public boolean isPrime(int n){
        for(int i=2;i<n;i++){
            if (n%i==0)return false;
        }
        return true;
    }
}
