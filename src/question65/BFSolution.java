package question65;

public class BFSolution {
    //时间复杂度：O(n)
    public boolean isNumber(String s) {
        if (s==null)return false;
        s = s.trim();
        if (s.length()==0)return false;
        boolean pointSeen = false;//是否出现过 .
        boolean eSeen = false;//是否出现过 e
        boolean numberSeen = false;//是否出现过 0-9
        boolean numberAfterE = true;//e之后是否出现 0-9
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {//当前元素是数字
                numberSeen = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {//当前元素是 .
                if(eSeen || pointSeen) {//已经出现过 e或者.，则非法
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e') {//当前元素 e
                if(eSeen || !numberSeen) {//已经出现过 e或者e之前没出现过数字，则非法
                    return false;
                }
                numberAfterE = false;//注意这点很重要，现在开始记录e之后是否有数字
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {//当前元素是-或+
                if(i != 0 && s.charAt(i-1) != 'e') {//如果-或+不是第一个元素 或者 之前不是 e
                    return false;
                }
            } else {//当前元素不是0-9、. 、e 、- 、+，非法
                return false;
            }
        }
        //是否有数字并且e之后也有数字
        return numberSeen && numberAfterE;
    }
}
