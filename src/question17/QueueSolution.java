package question17;

import java.util.ArrayList;
import java.util.List;

public class QueueSolution {
    public static void main(String[] args) {
        new QueueSolution().letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
//        边界处理
        if (digits==null||digits.length()==0)return res;
//        用数组或hashmap存储数字及其对应的字符表
        String[] letters={"","#","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//        先往队列中加入一个空字符，防止第一次循环从队列中取出第一个元素时出现下标越界异常
        res.add("");
//        遍历输入的字符串
        for(int i=0;i<digits.length();i++){
//            取出当前遍历数字对应的字符串
            String letter=letters[digits.charAt(i)-'0'];
//            获取当前队列的长度，不能在for循环中直接j<res.size()，因为内层循环中队列在不断增长，导致死循环
            int size = res.size();
//            遍历队列中每个元素
            for (int j=0;j<size;j++){
//                从队列中取出第一个元素
                String temp = res.remove(0);
//                遍历当前数字对应的字符串的每个字符，依次和取出的第一个元素拼接后重新放入队列
                for (int k=0;k<letter.length();k++){
                    res.add(temp+letter.charAt(k));
                }
            }
        }
        return res;
    }
}
