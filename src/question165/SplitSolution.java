package question165;

public class SplitSolution {
    //时间复杂度：O(n+m+Max(n,m))	n和m分别是输入字符串的长度。
    //空间复杂度：O(n+m)
    public int compareVersion(String version1, String version2) {
        //分割,注意转义字符
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int len1 = strs1.length, len2 = strs2.length;
        int len = Math.max(len1, len2);
        //每段数字分别 atoi 之后比较
        for (int i = 0; i < len; i++) {
            int x = i < len1 ? Integer.parseInt(strs1[i]) : 0;
            int y = i < len2 ? Integer.parseInt(strs2[i]) : 0;
            int res = compare(x, y);
            if (res != 0) return res;
        }
        return 0;
    }

    private int compare(int x, int y) {
        if (x == y) {
            return 0;
        } else if (x > y) {
            return 1;
        } else {
            return -1;
        }
    }
}
