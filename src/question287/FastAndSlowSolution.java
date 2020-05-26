package question287;

public class FastAndSlowSolution {
    //时间复杂度：O(n)	空间复杂度：O(1)
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            //第一次相遇
            if (slow == fast) break;
        }
        //重置一个指针,快慢指针都每次一个步长
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        //第二次相遇就是环入口
        return slow;
    }
}
