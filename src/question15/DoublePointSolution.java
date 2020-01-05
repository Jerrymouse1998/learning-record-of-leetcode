package question15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoublePointSolution {
//    时间复杂度：O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int len = nums.length;
        if (nums==null||len<3)return ans;
//        1.排序
        Arrays.sort(nums);
//        2. 依次遍历数组元素
        for (int i=0;i<len;i++){
//            如果当前元素已经大于0，那么之后所有的三数之和一定都大于0。结束循环。
            if (nums[i]>0)break;
//            4. 如果nums[i]==nums[i-1]，就会导致结果重复，所以应该跳过。
            if (i>0&&nums[i]==nums[i-1])continue;
//            用左右指针指向nums[i]后面元素部分的两端
            int L=i+1;
            int R=len-1;
//            循环直至左右指针相遇，即后面元素部分已组合完毕，则本次循环结束。
            while (L<R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum==0){
//                    三数之和等于0，等于0则加入结果集。
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
//                    5. 如果sum\=\=0的时候,nums[L]\=\=num[L+1]就会导致结果重复，所以应该跳过，L++。
                    while (L<R&&nums[L]==nums[L+1])L++;
//                    6. 如果sum\=\=0的时候，nums[R]=nums[R-1]就会导致结果重复，所以应该跳过，R--。
                    while (L<R&&nums[R]==nums[R-1])R--;
                    L++;
                    R--;
                }else if (sum>0){//如果sum>0，则说明需要较小的数字，即"R--"
                    R--;
                }else if (sum<0){//如果sum<0，则说明需要较大的数字，即"L++"
                    L++;
                }
            }
        }
        return ans;
    }
}
