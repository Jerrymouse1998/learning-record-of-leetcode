package question5;

public class ExpandCenterSolution {

    public String longestPalindrome(String s) {
//        如果是空串，则直接返回空串表示没有回文串
        if (s==null||s.length()<1)return "";
        int start=0,end=0;
        for (int i=0;i<s.length();i++){
//            判断i为中心的基数回文长度
            int len1=expandAroundCenter(s,i,i);
//            判断i和i+1为中心的偶数回文长度
            int len2=expandAroundCenter(s,i,i+1);
            int len=Math.max(len1,len2);
//            如果新回文串的长度大于之前的回文串长度，则更新
            if (len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
//        因为substring()方法截取的范围是[起始索引,结束索引)，所以第二个参数需要+1
        return s.substring(start,end+1);
    }

    public int expandAroundCenter(String s,int left,int right){
//        当左标记大于等于0,且右标记小于输入串长，且当前左右标记的字符相等时，左右标记分别中心扩展
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
//        返回以i或(i，i+1)为中心的回文串长度。
//        因为跳出循环之前左或右标记到达最小或最大值时，会多进行一次--或++，所以返回结果要-1
        return right-left-1;
    }
}
