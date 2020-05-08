package question164;

public class CountingSortSolution {
    //时间复杂度：O(n + K) 两次遍历 + 遍历计数器 O(K)    K = max - min
    //空间复杂度：O(K)	输入 **[2,99999999]** 内存超出了！！
    public int maximumGap(int[] nums) {
        //计数
        if (nums.length < 2) return 0;
        int max = nums[0], min = nums[0], bias = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        bias = 0 - min;
        int[] counter = new int[max - min + 1];
        for (int num : nums) {
            counter[num + bias]++;
        }
        //求最大差值，pre记录前一个元素
        int ans = 0;
        int pre = -1;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                if (pre != -1) {
                    ans = Math.max(ans, i - pre);
                    pre = i;
                } else {
                    pre = i;
                }
            }
        }
        return ans;
    }
}
