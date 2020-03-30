package offer62;

public class JosephusSolution {
    //时间复杂度：O(n)
    public int lastRemaining(int n, int m) {
        int ans=0;
        for (int i = 2; i <= n; i++) {
            ans=(ans+m)%i;
        }
        return ans;
    }
}
