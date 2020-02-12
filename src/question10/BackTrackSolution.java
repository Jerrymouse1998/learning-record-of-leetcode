package question10;

public class BackTrackSolution {
    //时间复杂度：O((n+m)*2^(n+m/2)) n和m分别是s和p的长度
    public boolean isMatch(String s, String p) {
        //如果正则串p为空字符串s也为空这匹配成功，如果正则串p为空但是s不是空则说明匹配失败
        if (p.isEmpty())return s.isEmpty();
        //判断s和p的首字符是否匹配，注意要先判断s不为空
        boolean headMatched=!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
        if (p.length()>=2&&p.charAt(1)=='*'){//如果p的第一个元素的下一个元素是*
            //则分别对两种情况进行判断
            return isMatch(s,p.substring(2))||
                    (headMatched&&isMatch(s.substring(1),p));
        }else if (headMatched){//否则，如果s和p的首字符相等
            return isMatch(s.substring(1),p.substring(1));
        }else {
            return false;
        }
    }
}
