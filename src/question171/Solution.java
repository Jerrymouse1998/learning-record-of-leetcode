package question171;

public class Solution {
    //时间复杂度：O(n)
    public int titleToNumber(String s) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            int temp = c-'A';
            ans = ans*10 + temp;
        }
        return ans;
    }
}
