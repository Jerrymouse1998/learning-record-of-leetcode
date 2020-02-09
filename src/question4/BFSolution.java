package question4;

public class BFSolution {
    //时间复杂度：O(n+m)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num=new int[nums1.length+nums2.length];
        int count=0,i=0,j=0;
        //合并两个有序数组
        while (count<(nums1.length+nums2.length)){
            if (i<nums1.length&&j<nums2.length){
                if (nums1[i]<nums2[j]){
                    num[count++]=nums1[i++];
                }else {
                    num[count++]=nums2[j++];
                }
            }else if (i<nums1.length){
                num[count++]=nums1[i++];
            }else if (j<nums2.length){
                num[count++]=nums2[j++];
            }
        }
        //判断合并后的数组元素个数的奇偶性
        if (count%2==0){
            //注意这里是2.0，如果是2会导致结果为int类型丢失精度
            return (num[count/2-1]+num[count/2])/2.0;
        }else {
            return num[count/2];
        }
    }
}
