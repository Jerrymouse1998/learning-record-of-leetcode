package question151;

public class APISolution {
    //时间复杂度：O(n) 空间复杂度：O(n)
    public String reverseWords(String s) {
        if (s==null)return s;
        //分割s
        String[] strs = s.split(" ");
        StringBuilder sb=new StringBuilder();
        //逆序遍历
        for (int i = strs.length-1; i >= 0; i--) {
            //跳过空串
            if (strs[i].equals(""))continue;
            sb.append(strs[i]).append(" ");
        }
        //去除最后一个多余的空格
        return sb.toString().trim();
    }
}
