package question125;

public class DoublePointerSolution {
    //时间复杂度：O(n)
    public boolean isPalindrome(String s) {
        if (s == null) return true;
        //忽略大小写
        String lower = s.toLowerCase();
        //双指针
        int i = 0, j = lower.length() - 1;
        while (i < j) {
            char ci = lower.charAt(i);
            char cj = lower.charAt(j);
            //不是字符或数字跳过
            if (!Character.isLetterOrDigit(ci)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(cj)) {
                j--;
                continue;
            }
            //不相等false
            if (ci != cj) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
