package question229;

import java.util.ArrayList;
import java.util.List;

public class MooreVotingSolution {
    //时间复杂度：O(n)
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if (nums==null||nums.length==0)return res;
        int candidate1=0,candidate2=0,count1=0,count2=0;
        for (int num : nums) {
            //投给A或者B
            if (num==candidate1){
                count1++;
                continue;
            }
            if (num == candidate2) {
                count2++;
                continue;
            }
            //不投给A和B且A或B等于0
            if (count1 == 0) {
                candidate1=num;
                count1++;
                continue;
            }
            if (count2 == 0) {
                candidate2=num;
                count2++;
                continue;
            }
            //不投给A和B且A和B不等于0
            count1--;
            count2--;
        }
        //检查A和B是否符合要求
        count1=count2=0;
        for (int num : nums) {
            //必须是else if，防止所有元素都相等的情况
            if (num == candidate1){
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        if (count1>nums.length/3)res.add(candidate1);
        if (count2>nums.length/3)res.add(candidate2);
        return res;
    }
}
