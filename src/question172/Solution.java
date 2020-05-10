package question172;

public class Solution {
    //时间复杂度：O(logn)
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n/5;
            n/=5;
        }
        return count;
    }

    ////时间复杂度：O(n)	不符合要求，超时！
    //public int trailingZeroes(int n) {
    //    int count = 0;
    //    //遍历
    //    for (int i = 1; i <= n; i++) {
    //        //是 5 的倍数,统计能分解成几个 5
    //        int num = i;
    //        while (num > 0) {
    //            if (num % 5 == 0) {
    //                count ++;
    //                num /= 5;
    //            }else {
    //                break;
    //            }
    //        }
    //    }
    //    return count;
    //}
}
