package question836;

public class Solution {
    //时间复杂度：O(1)
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //x、y轴投影区间不重叠两种情况，非运算就是重叠
        boolean xIsOverlap=!(rec1[2]<=rec2[0]||rec2[2]<=rec1[0]);
        boolean yIsOverlap=!(rec1[3]<=rec2[1]||rec2[3]<=rec1[1]);
        //当且仅当x、y轴区间都重叠，矩形才重叠
        return xIsOverlap&&yIsOverlap;
    }
}
