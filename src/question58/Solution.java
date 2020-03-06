package question58;

public class Solution {
    //时间复杂度：O(n)
    public int lengthOfLastWord(String s) {
        if (s==null||s.equals(""))return 0;
        String str = s.trim();
        int i=str.length()-1;
        for (; i >= 0; i--) {
            if (str.charAt(i)==' ')break;
        }
        return str.length()-i;
    }
}
