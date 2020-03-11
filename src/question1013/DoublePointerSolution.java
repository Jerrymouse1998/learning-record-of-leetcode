package question1013;

public class DoublePointerSolution {
    //时间复杂度：O(n)
    public boolean canThreePartsEqualSum(int[] A) {
        //元素总和必须是3的倍数
        int sum=0;
        for (int i : A) {
            sum+=i;
        }
        if (sum%3!=0)return false;
        //双指针找和等于sum/3的左右部分
        int left=0,right=A.length-1,leftSum=A[0],rightSum=A[A.length-1];
        //+1给中间部分留有"余地"
        while (left+1<right){
            if (leftSum == sum / 3 && rightSum == sum / 3) {
                return true;
            }
            if (leftSum != sum / 3) {
                leftSum+=A[++left];
            }
            if (rightSum != sum / 3) {
                rightSum+=A[--right];
            }
        }
        return false;
    }
}
