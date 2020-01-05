package question14;

public class OneByOneSolution_potimize {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0||strs==null)return "";
//        将0号元素的每个字符依次取出进行比较
        for (int i=0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
//            将0号元素的i号字符和数组的每个元素的i号字符依次比较
            for (int j=1;j<strs.length;j++){
                if (i==strs[j].length()||c!=strs[j].charAt(i))
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
}
