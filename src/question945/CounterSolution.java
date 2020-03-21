package question945;

public class CounterSolution {

    //时间复杂度：O(n+k)  n数组长度，k范围，本题可以看做范围是个常数，复杂度O(n)
    public int minIncrementForUnique(int[] A) {
        if (A.length<2)return 0;
        int ans=0;
        //统计数量
        int[] counter=new int[80000];
        for (int i : A) {
            counter[i]++;
        }
        for (int i = 0; i < counter.length; i++) {
            //如果当前元素数量大于1，则将多余元素都分别move后都计入增加后的位置
            if (counter[i] > 1) {
                ans+=counter[i]-1;
                counter[i+1]+=counter[i]-1;
            }
        }
        return ans;
    }
}
