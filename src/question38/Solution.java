package question38;

public class Solution {
    public String countAndSay(int n) {
        //第一项外观数列为"1"
        if (n==1)return "1";
        String s="1";
        //按序生成n个外观数列，从第二项开始
        for (int i=0;i<n-1;i++){
            //temp是当前生成的外观数列、c初始化为前一项的第一个字符、count记录前一项连续相等的的字符
            StringBuilder temp=new StringBuilder();
            char c = s.charAt(0);
            int count=1;
            //遍历前一项外观数列的每个字符
            for (int j=1;j<s.length();j++){
                //如果连续的字符相等，则count计数器增加
                if (c==s.charAt(j)){
                    count++;
                }else {
                    //如果连续字符不相等，则将连续字符数量和字符拼接至temp
                    temp.append(count).append(c);
                    //c更新为当前遍历的字符，计数器重置为1
                    c=s.charAt(j);
                    count=1;
                }
            }
            //注意，很容易遗漏的一步：将最后未拼接的字符加入temp
            temp.append(count).append(c);
            //更新s
            s=temp.toString();
        }
        return s;
    }
}
