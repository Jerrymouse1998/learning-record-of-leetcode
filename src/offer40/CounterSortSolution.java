package offer40;

public class CounterSortSolution {
    //时间复杂度：O(n+m)  n数组元素个数，m范围。
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k==0)return new int[0];
        //计数
        int[] counter=new int[10001];
        for (int e : arr) {
            counter[e]++;
        }
        //从小到大范围找出k个元素
        int index=0;
        int[] res=new int[k];
        for (int i = 0; i < counter.length; i++) {
            while (counter[i]-- > 0 && index < k) {
                res[index++]=i;
            }
            if (index==k)break;
        }
        return res;
    }
}
