package question88;

public class DoublePointerSolution2 {
    //时间复杂度：O(m+n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //指针都指向尾部，比较大的元素优先合并至nums1尾部
        int i=m-1,j=n-1,index=nums1.length-1;
        while (i>=0&&j>=0){
            nums1[index--]=(nums1[i]>nums2[j]?nums1[i--]:nums2[j--]);
        }
        //检查是否有剩余
        while (i>=0)nums1[index--]=nums1[i--];
        while (j>=0)nums1[index--]=nums2[j--];
    }
}
