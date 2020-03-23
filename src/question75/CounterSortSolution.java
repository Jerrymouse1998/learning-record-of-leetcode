package question75;

public class CounterSortSolution {
    //时间复杂度：O(n)
    public void sortColors(int[] nums) {
        //计数
        int[] counter=new int[3];
        for (int num : nums) {
            counter[num]++;
        }
        //重写
        int idx=0;
        for (int i=0;i<counter.length;i++) {
            while (counter[i]-- > 0) {
                nums[idx++]=i;
            }
        }
    }
}
