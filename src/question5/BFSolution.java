package question5;

public class BFSolution {
    public static void main(String[] args) {
        System.out.println(new BFSolution().longestPalindrome("babad"));
    }
//时间复杂度:O(n^3)
    public String longestPalindrome(String s) {
        String ans="";
        int len=0;
        for (int i=0;i<s.length();i++){
            for (int j=i+1;j<s.length();j++){
                if (isPalindrome(s.substring(i,j))&&len<j-i+1){
                    ans=s.substring(i,j);
                    len=Math.max(len,ans.length());
                }
            }
        }
        return ans;
    }

    boolean isPalindrome(String s){
        for (int i=0;i<s.length()/2;i++){
            if (s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
}
