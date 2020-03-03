package question88;

public class DoublePointerSolution {
    //时间复杂度：O(m+n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //保存nums1的m个元素
        int[] A2=new int[m];
        for (int i = 0; i < m; i++) {
            A2[i]=nums1[i];
        }
        //双指针比较并合并保存到nums1中
        int i=0,j=0,index=0;
        while (i<A2.length&&j<nums2.length){
            nums1[index++]=(A2[i]<nums2[j]?A2[i++]:nums2[j++]);
        }
        //两个数组有剩余时保存到nums1后面
        while (j<nums2.length)nums1[index++]=nums2[j++];
        while (i<A2.length)nums1[index++]=A2[i++];
    }
}
