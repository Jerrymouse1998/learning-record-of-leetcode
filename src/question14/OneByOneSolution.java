package question14;

public class OneByOneSolution {

    public String longestCommonPrefix(String[] strs) {
        if (strs==null||strs.length==0)return "";
        String prefix=strs[0];
//        依次和数组的元素求公共前缀
        for (int i=1;i<strs.length;i++){
//            如果不是当前被比较元素的公共前缀
            while (strs[i].indexOf(prefix)!=0){
//                从后面减少当前最长公共前缀的长度
                prefix=prefix.substring(0,prefix.length()-1);
//                如果当前最长公共前缀已经为空，则说明该数组的元素没有公共前缀
                if (prefix.isEmpty())return "";
            }
        }
        return prefix;
    }
}
