package question80;

public class DoublePointerSolution {
    //时间复杂度：O(n)
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 3) return nums.length;
        int i = 1, j = 1, counter = 1;
        //j遍历数组
        for (; j < nums.length; j++) {
            //如果相等计数器加一，否则置为1
            if (nums[j] == nums[j - 1]) {
                counter++;
            } else {
                counter = 1;
            }
            //如果当前计数器不大于2，将j元素覆盖到i元素上，i移动
            if (counter <= 2) {
                nums[i++]=nums[j];
            }
        }
        return i;
    }
}
