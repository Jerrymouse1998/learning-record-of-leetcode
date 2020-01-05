package question28;

public class KMPSolution {

        public int strStr(String haystack, String needle) {
            int tarsize = needle.length();                //短字符串
            int scrsize = haystack.length();              //长字符串
            if(tarsize == 0)                              //短字符串是0
                return 0;
            if(tarsize > scrsize)                         //短字符串 比 长字符串长
                return -1;
            if(tarsize == scrsize && needle.equals(haystack))    //两个字符串相同
                return 0;
            int start = 0;                             //长字符串的和短字符串比较的第一个字符
            int i = 0;                          //长字符串的和短字符串正在比较的相对第一个位置
            int[] next = getNext(needle);       //得到next数组
            while (start <= scrsize - tarsize)
            {
                if(haystack.charAt(start + i) == needle.charAt(i))
                {
                    i++;
                    if(i == tarsize)
                        return start;
                }
                else
                {
                    start = start + i - next[i];
                    i = i > 0 ? next[i] : 0;
                }
            }
            return -1;
        }

        public int[] getNext(String needle)
        {
            int tarsize = needle.length();
            int[] next =  new int[tarsize];
            next[0] = -1;
            if(tarsize > 1)
                next[1] = 0;
            int i = 2;
            int j = 0;
            while(i < tarsize)
            {
                if(needle.charAt(i-1) == needle.charAt(j))   //
                {
                    next[i] = j+1;
                    j++;
                    i++;
                }
                else if(j > 0)
                {
                    j = next[j];
                }
                else
                {
                    next[i] = 0;
                    i++;
                }
            }
            return next;
        }
}
