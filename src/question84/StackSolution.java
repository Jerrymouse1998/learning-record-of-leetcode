package question84;

import java.util.Stack;

public class StackSolution {
    //时间复杂度：O(n)	所有元素入队一次，出队一次。
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        //辅助,标记栈底
        stack.push(-1);
        int maxArea=0;
        //遍历入栈
        for (int i = 0; i < heights.length; i++) {
            //当栈不空并且当前元素不符合单调递增栈的要求
            //就出栈栈顶元素作为高，求形成的矩形最大面积
            while (stack.peek()!=-1&&heights[stack.peek()]>heights[i]){
                maxArea=Math.max(maxArea,heights[stack.pop()]*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        //遍历入栈完毕之后，将栈里的元素陆续出栈并作为高，求形成的矩形最大面积
        while (stack.peek() != -1) {
            maxArea=Math.max(maxArea,heights[stack.pop()]*(heights.length-stack.peek()-1));
        }
        return maxArea;
    }
}
