package question1111;

public class StackSolution {
    //时间复杂度：O(n)
    public int[] maxDepthAfterSplit(String seq) {
        if (seq == null || seq.equals("")) return new int[0];
        int depth=0;
        int[] res = new int[seq.length()];
        //遍历
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {//入栈,栈内深度增加
                res[i] = ++depth % 2;
            } else {//出栈，栈内深度减少
                res[i] = depth-- % 2;
            }
        }
        return res;
    }
}
