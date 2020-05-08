package question165;

public class SplitSolution2 {

    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int len1 = strs1.length, len2 = strs2.length;
        int len = Math.max(len1, len2);
        for (int i = 0; i < len; i++) {
            String x = i < len1 ? strs1[i] : "0";
            String y = i < len2 ? strs2[i] : "0";
            int res = compare(x, y);
            if (res != 0) return res;
        }
        return 0;
    }

    private int compare(String x, String y) {
        //删去高位 0
        x = removeHead0(x);
        y = removeHead0(y);
        //比较位数
        if (x.length() > y.length()) {
            return 1;
        } else if (x.length() < y.length()) {
            return -1;
        } else {
            //位数相等,从高位开始比较
            for (int i = 0; i < x.length(); i++) {
                int sub = x.charAt(i) - y.charAt(i);
                if (sub > 0) {
                    return 1;
                } else if (sub < 0) {
                    return -1;
                }
            }
            return 0;
        }
    }

    private String removeHead0(String s) {
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                i++;
            } else {
                break;
            }
        }
        return s.substring(i);
    }
}
