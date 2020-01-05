package question16;

import java.util.ArrayList;
import java.util.List;

public class BFSolution {
    public static void main(String[] args) {
        int[] nums={38,60,-3,-12,48,100,18,-76,-12,-99,45,67,42,66,-25,-38,-52,-53,57,53,100,-60,75,-75,-52,-98,80,49,87,35,9,6,-37,48,23,-30,86,-6,57,80,86,39,-74,-18,0,37,-93,-36,1,89,-51,-80,-40,-63,-32,4,-52,48,29,-52,-86,4,-32,-73,91,91,11,44,22,47,48,38,61,-92,-86,86,98,15,-97,96,-82,94,-22,77,-44,-66,-40,-58,-89,23,-24,-11,-64,-17,12,12,-30,19,43,64,-85,-44,-65,-58,83,-94,55,95,63,11,56,-35,-62,-38,15,-91,-97,-57,69,-82,-61,58,-12,32,-96,-16,-33,37,-72,-66,43,19,23,-33,-22,-44,-22,97,87,-75,38,100,9,99,10,0,-86,-25,95,-1,39,32,45,-61,24,80,-59,66,-81,-82,27,-77,34,-88,25,12,66,57,39,-75,86,92,-65,-12,-87,2,-7,-58,-46,-3,-67,1,-92,-77,-42,60,72,71,74,-82,75,-39,28,91,-76,-10,-41,-41,36,63,-35,71,-6,-8,-57,6,-5,80,76,-73,96,-59,61,-69,84,-40,-87};
        System.out.println(new BFSolution().threeSumClosest(nums,-20));
    }

    public int threeSumClosest(int[] nums, int target) {
        int len=nums.length;
        if (nums==null||len<3)throw new IllegalArgumentException("error of argument!");
//        用list保存所有的三数之和
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<len;i++){
            for (int j=i+1;j<len;j++){
                for (int k=j+1;k<len;k++){
                    list.add(nums[i]+nums[j]+nums[k]);
                }
            }
        }
//        遍历list找出最接近target的数
        int ans=list.get(0);
        for (Integer i : list) {
            if (Math.abs(target-ans)>Math.abs(target-i))
                    ans=i;
        }
        return ans;
    }
}
