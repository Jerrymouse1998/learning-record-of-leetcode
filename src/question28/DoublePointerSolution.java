package question28;

public class DoublePointerSolution {

    public int strStr(String haystack, String needle) {
        if (haystack==null||needle==null)throw new NullPointerException();
        int i=0,j=0;
        for (;i<haystack.length()&&j<needle.length();i++){
            if (haystack.charAt(i)==needle.charAt(j)){
                j++;
            }else {
                i=i-j;
                j=0;
            }
        }
        return j<needle.length()?-1:i-j;
    }
}
