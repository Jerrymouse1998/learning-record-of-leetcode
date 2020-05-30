package question394;

import java.util.Deque;
import java.util.LinkedList;

public class StackSolution {
    //时间复杂度：O(n)	空间复杂度：O(n)
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        int num = 0;
        Deque<StringBuilder> strings = new LinkedList<>();
        Deque<Integer> nums = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (Character.isLetter(c)) {
                ans.append(c);
            } else if (c == '[') {
                strings.push(ans);
                ans = new StringBuilder();
                nums.push(num);
                num = 0;
            } else if (c == ']') {
                StringBuilder ansTemp = strings.pop();
                int numTemp = nums.pop();
                for (int i = 0; i < numTemp; i++) {
                    ansTemp.append(ans);
                }
                ans = ansTemp;
            }
        }
        return ans.toString();
    }
}
