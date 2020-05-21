package question189;

public class Solution {
    //时间复杂度：O(n) 每个元素换位一次
    //空间复杂度：O(1)
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        //记录换位次数
        int count = 0;
        //从哪个位置开始换位
        int start = 0;
        while (count < len) {
            //本轮从哪个位置开始换位
            int curr = start;
            //需要换位的元素
            int pre = nums[curr];
            //开始本轮换位
            do {
                //要去抢占的位置
                int next = (curr + k) % len;
                //被赶走的元素
                int temp = nums[next];
                //pre 坐下
                nums[next] = pre;
                //下一个需要换位的元素 和 元素原本的位置
                pre = temp;
                curr = next;
                count++;
            } while (start != curr);
            start++;
        }
    }
}
