package question18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoublePointSolution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        int len=nums.length;
        if (nums==null||len<4)return ans;
//        排序
        Arrays.sort(nums);

//        遍历数组每一个元素,因为是求四数之和，所以i<len-3
        for (int i=0;i<len-3;i++){
//            如果当前最小的四数之和已经大于target，则结束循环
            if (nums[i]+nums[i+1]+nums[i+2]+nums[i+3]> target)break;
//            如果当前最大的四数之和依然小于target，则跳过当前元素，进行下一个元素
            if (nums[i]+nums[len-1]+nums[len-2]+nums[len-3]< target)continue;
//            跳过重复的元素
            if (i>0&&nums[i]==nums[i-1])continue;
//            当前数组想要组成target所需要的值
            int temp=target-nums[i];

//            遍历i号元素后面部分的每个元素，因为是求三数之和，所以i<len-2
            for (int j=i+1;j<len-2;j++){
//                跳过重复元素
                if (j>i+1&&nums[j]==nums[j-1])continue;
//                用双指针分别指向j号元素后面部分的开始元素和结尾元素
                int L=j+1,R=len-1;
                while (L<R){
                    int sum=nums[j]+nums[L]+nums[R];
                    if (sum==temp){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[L],nums[R]));
                        while (L<R&&nums[L]==nums[L+1])L++;
                        while (L<R&&nums[R]==nums[R-1])R--;
                        L++;
                        R--;
                    }else if (sum<temp){
                        L++;
                    }else if (sum>temp){
                        R--;
                    }
                }
            }
        }
        return ans;
    }
}
