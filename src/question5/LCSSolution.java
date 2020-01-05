package question5;

public class LCSSolution {
    public static void main(String[] args) {
        System.out.println(new LCSSolution().longestPalindrome("abc435cba"));
    }

    public String longestPalindrome(String s) {
        if (s.equals(""))return "";
        String origin=s;
//        倒置原字符串
        String reverse=new StringBuffer(s).reverse().toString();
//        maxLen记录最长公共子序列，maxEnd记录最长公共子序列的结尾下标
        int maxLen=0,maxEnd=0;
//        分别以原字符串长度和倒置字符串长度来表示，是为了更直观的理解该二维数组
        int[] arr=new int[s.length()];
//        双重循环遍历二维数组
        for (int i=0;i<origin.length();i++){
            for (int j=reverse.length()-1;j>=0;j--){
//                判断原字符串i位置字符和倒置字符串j位置字符是否相等
                if (origin.charAt(i)==reverse.charAt(j)){
                    if (i==0||j==0){//当i=0或j=0时候单独分析，如果对应位置字符相等 arr\[i\]\[j\]=1
                        arr[j]=1;
                    }else{
                        arr[j]=arr[j-1]+1;
                    }
                }else {//之前是二维数组每一列默认值就是0，现在是一维数组所以需要手动更新为0
                    arr[j]=0;
                }
//                如果当前公共子串长度比maxLen所记录的值更大，则更新最长公共子串的长度及其结束下标
                if (arr[j]>maxLen){
                    int beforeReverse=origin.length()-1-j;
                    if (beforeReverse+arr[j]-1==i) {
                        maxLen = arr[j];
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd-maxLen+1,maxEnd+1);
    }
}
