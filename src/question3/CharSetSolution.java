package question3;

public class CharSetSolution {
    public static void main(String[] args) {
        System.out.println(new CharSetSolution().lengthOfLongestSubstring("tmmzuxt"));
    }

    /**
     *就题说题，针对这道题有一种思路：
     * 假设字符集较小（只有字母和符号等等，不含中文等等），我们可以用一个整数数组作为直接的访问表来代替map。
     * int[24]假设字符集只含有字母'a'-'z'或'A'-'Z'
     * int[128]假设字符集只含有ASCII
     * int[256]假设字符集只含有扩展ASCII
     * 这里我们假设字符集只含有ASCII
     */
//    时间复杂度：O(n)
    public int lengthOfLongestSubstring(String s) {
        int count=0;
//        数组作为直接访问表代替map
        int[] index=new int[128];
        for (int j=0,i=0;j<s.length();j++){
//            如果index[s.charAt(j)]的值大于i，则说明当前窗口中元素与第j个字符重复了，
//            就让i=index[s.charAt(j)]，使窗口一次性移动到不含重复元素的位置
            i=Math.max(i,index[s.charAt(j)]);
//            记录窗口中元素个数,如果不重复元素个数大于之前的记录值,就更新count
            count=Math.max(count,j-i+1);
//            使当前元素作为数组下标并将该元素的下标+1更新至数组,形成类似于hashmap中k-v对的形式
            index[s.charAt(j)]=j+1;
        }
        return count;
    }
}
