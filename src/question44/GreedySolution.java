package question44;

public class GreedySolution {
    //时间复杂度：O(mn)  m、n分别是s和p的长度
    public boolean isMatch(String s, String p) {
        if (p==null||p.isEmpty())return s==null||s.isEmpty();
        int i=0,j=0,istart=-1,jstart=-1,slen=s.length(),plen=p.length();
        //判断s的所有字符是否匹配
        while (i<slen){
            //三种匹配成功情况以及匹配失败返回false
            if (j<plen&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')){
                i++;
                j++;
            }else if (j<plen&&p.charAt(j)=='*'){
                istart=i;
                jstart=j++;
            }else if (istart>-1){
                i=++istart;
                j=jstart+1;
            }else {
                return false;
            }
        }
        //s中的字符都判断完毕，则认为s为空，此时需要p为空或者p中只剩下星号的时候，才能成功匹配。
        //如果p中剩余的都是*，则可以移除剩余的*
        while (j<plen&&p.charAt(j)=='*')j++;
        return j==plen;
    }
}
