package question1013;

public class CounterSolution {
    //时间复杂度：O(n)
    public boolean canThreePartsEqualSum(int[] A) {
        //元素总和必须是3的倍数
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) return false;
        //顺序遍历找等于sum/3的部分
        int count = 0, partialSum = 0;
        for (int i : A) {
            partialSum += i;
            if (partialSum == sum/3) {
                partialSum=0;
                count++;
            }
        }
        return count>=3;
    }
}
