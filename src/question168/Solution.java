package question168;

public class Solution {

    public String convertToTitle(int n) {
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            n--;
            ans.append((char) ('A' + n % 26));
            n/=26;
        }
        return ans.reverse().toString();
    }
}
