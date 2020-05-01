package question135;

import java.util.Arrays;

public class GreedySolution {
    //时间复杂度：O(n)	五次遍历。
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        //初始化每人最少一个糖
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        //顺序遍历,按照规则一进行分配
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        }
        //逆序遍历,按照规则二进行分配
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
        }
        //统计所有孩子的糖果
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            //每个孩子按照,规则一和规则二中相应最大的数字进行分配
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }

    //时间复杂度：O(n) 两次遍历
    //public int candy(int[] ratings) {
    //    int[] candies = new int[ratings.length];
    //    //初始化
    //    candies[0] = 1;
    //    //顺序遍历
    //    for (int i = 1; i < ratings.length; i++) {
    //        //分数大于前面的孩子,则多一个糖
    //        if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
    //            //否则1个
    //        else candies[i] = 1;
    //    }
    //    //注意不要漏统计最后一个孩子
    //    int sum = candies[candies.length - 1];
    //    for (int i = ratings.length - 2; i >= 0; i--) {
    //        //只有当左大于右,且左孩子的糖少于右孩子时才更新
    //        if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
    //        //统计
    //        sum += candies[i];
    //    }
    //    return sum;
    //}
}
