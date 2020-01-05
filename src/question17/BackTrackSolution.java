package question17;

import java.util.ArrayList;
import java.util.List;

public class BackTrackSolution {
//    用数组或hashmap存储数字及其对应的字符表
    String[] letters={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//    结果集
    List<String> result=new ArrayList<>();

    public List<String> letterCombinations(String digits) {
//        边界处理
        if (digits.length()==0||digits==null)return result;
        backTrack(digits,"",0);
        return result;
    }

//    递归函数
    public void backTrack(String str,String combination,int index){
//        递归终止条件，当index==str.length()时说明str==""
        if (index==str.length()){
            result.add(combination);
            return;
        }
//        获取当前index位置的字符，假设输入的“234”
//        第一次递归时index为0所以c=‘2’，第二次index=1所以c=‘3’，第三次c=‘4’
//        subString()每次都会生成新的字符串，而用index方式取当前第一个字符，效率更高一点
        char c= str.charAt(index);
        String letter=letters[c-'0'];
//        遍历letter字符串，例如第一次得到的是‘2’，即遍历“abc”
        for (int i=0;i<letter.length();i++){
//            这里是比较值得思考的地方，递归调用
            backTrack(str,combination+letter.charAt(i),index+1);
        }
    }

}
