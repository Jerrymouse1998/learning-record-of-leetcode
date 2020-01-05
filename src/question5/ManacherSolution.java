package question5;

public class ManacherSolution {
    public static void main(String[] args) {
        System.out.println(new ManacherSolution().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
//        获取扩充后的字符串T
        String T=preProsess(s);
        int len=T.length();
        int[] p=new int[len];
        int c=0,r=0;
//        不需要判断前后边界字符“^"和“$”，所以循环范围是[1,len-1)
        for (int i=1;i<len-1;i++){
//            第i个字符关于c对称的下标
            int i_mirror=2*c-i;
            if (r>i){//如果i小于对称半径r
                p[i]=Math.max(r-i,p[i_mirror]);
            }else {
                p[i]=0;
            }

//            遇到三种特殊情况时，需要退化到中心扩展法
            while (T.charAt(i+1+p[i])==T.charAt(i-1-p[i])){
                p[i]++;
            }

//            判断是否需要更新c和r
            if (i+p[i]>r){
                c=i;
                r=p[i];
            }
        }
//        找出p[]数组中最大的值
        int currentIndex=0,maxLen=0;
        for (int i=0;i<p.length;i++){
            if (p[i]>maxLen){
                currentIndex=i;
                maxLen=p[i];
            }
        }

//        求子串首字符在原字符串中的下标
        int start=(currentIndex-maxLen)/2;
        return s.substring(start,start+maxLen);
    }
    //    扩充字符串
    public String preProsess(String s){
        if (s.equals(""))return "$";
        String result="^";
        for (int i=0;i<s.length();i++){
            result+="#"+s.charAt(i);
        }
        result+="#$";
        return result;
    }
}
