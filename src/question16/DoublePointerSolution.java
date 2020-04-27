package question16;

import java.util.Arrays;

public class DoublePointerSolution {
    //    时间复杂度：O(n^2)
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) throw new IllegalArgumentException("error of argument!");
        int len = nums.length, ans = nums[0] + nums[1] + nums[2];
//        对数组排序
        Arrays.sort(nums);
//        依次遍历每个元素nums[i]
        for (int i = 0; i < len; i++) {
//            然后用前后指针L和R分别指向nums[i]后面部分的开头和结尾
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (Math.abs(target - ans) > Math.abs(target - sum)) {
                    ans = sum;
                }
                if (sum == target) {//如果sum==target，那就已经找到最接近target的三数之和
                    return ans;
                } else if (sum < target) {//如果sum<target，说明需要大一点的数来组合，即L++
                    L++;
                } else if (sum > target) {//如果sum<target，说明需要小一点的数来组合，即R--；
                    R--;
                }
            }
        }
        return ans;
    }
}