package question4;

public class DichotomySolution {
    //时间复杂度：O(log(m+n))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        //将奇数和偶数情况统一处理，如果是奇数情况就求两次。这部分也可以用判断分别处理
        int Kth1=(len1+len2+1)/2,Kth2=(len1+len2+2)/2;
        //注意最后结果是double，如果/2会丢失精度
        return (findKth(nums1,0,len1-1,nums2,0,len2-1,Kth1)
                +findKth(nums1,0,len1-1,nums2,0,len2-1,Kth2))/2.0;
    }
    public int findKth(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
        //计算两个数组剩余部分长度
        int len1=end1-start1+1;
        int len2=end2-start2+1;
        //很巧妙的一步，让len1总是剩余长度较小的那个，如果出现为空的情况一定是len1
        if (len1>len2)return findKth(nums2,start2,end2,nums1,start1,end1,k);
        //递归的出口，当某个数组剩余长度为0或者k==1的时候
        if (len1==0)return nums2[start2+k-1];
        if (k==1)return Math.min(nums1[start1],nums2[start2]);
        //比较两个数组剩余部分的第k/2个元素大小，如果越界则取数组最后一个元素进行比较即可
        int i=start1+Math.min(len1,k/2)-1,j=start2+ Math.min(len2,k/2)-1;
        //排除较小的元素部分，k减去排除元素的个数
        if (nums1[i]<nums2[j]){
            return findKth(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));
        }else {
            return findKth(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
        }
    }
}
