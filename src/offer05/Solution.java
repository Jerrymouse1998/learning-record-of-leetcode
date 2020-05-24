package offer05;

public class Solution {
    //时间复杂度：O(n)    空间复杂度：O(n)
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                res.append(c);
            }else {
                res.append("%20");
            }
        }
        return res.toString();
    }
}
