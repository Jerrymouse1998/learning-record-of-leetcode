package question680;

public class Solution {
    //时间复杂度：O(n)	一次遍历
    //空间复杂度：O(1)
    public boolean validPalindrome(String s) {
        if (s.equals("")) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                //s[i] 和 s[j] 不相等,分别删除 s[i] 或 s[j] 后判断是否为有效回文串
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        return true;
    }

    //双指针判断 s 的 [i,j] 子串是否为回文串
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

}
